package controllers;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.Files;
import com.opencsv.CSVWriter;

import etlFlowGraph.graph.ETLFlowGraph;
import importXLM.ImportXLMToETLGraph;

import org.apache.commons.lang.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import storage.IStorage;
import storage.IStorageProvider;
import storage.StorageProvider;
import views.html.index;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Application extends Controller {

	//final static Form<User> userForm = form(User.class);
	public static Result index() {
		return ok(views.html.index.render("Your new application is ready."));
	}

	// new view for the file upload
	public static Result pentaho() {
		return ok(views.html.pentaho.render("Hello Pentaho"));
	}

	/**
	 * The main method that uploads etl flows (xml files) through the form of
	 * the related view; stores them in the file system; sends them to slave
	 * apps, according to selected policy; receives from the slave apps
	 * execution metrics and stores them in the same file as the etl flows.
	 *
	 * @return pentaho results
	 */
	public static Result executionController() {
		MultipartFormData body = request().body().asMultipartFormData();
		List<MultipartFormData.FilePart> fileParts = body.getFiles();

		Integer executionCount = 1;
		DynamicForm form = Form.form().bindFromRequest();
		executionCount = Integer.parseInt(form.get("executionCount"));
		System.out.println("executionCount= "+executionCount);


		// getting the file path variable from application.conf, where to store
		// the files
		String uploadPath = Play.application().configuration()
				.getString("uploadPath");

		// string for the future result view in console
		StringBuffer sb = new StringBuffer();

		if (fileParts != null) {
			// variable for iterating the uploaded files
			int i = 0;

			// this for loop is for iterating between the uploaded files
			// (executionClient()) is called for every file
			for (MultipartFormData.FilePart fp : fileParts) {
				for (int count=0; count < executionCount; count++){
					String result = executionClient(uploadPath, fp);
					i++;
				}
			}
			//MonitoringController mControl = new MonitoringController();
			//mControl.getMeasures("AKIAJZMBVRZ3MKD43VJQ", "y0TAdsaAy6sxKzD+8NGi9oOFbgh9j23BCnuP4Qhk", "i-253685e4");
			// System.out.println(sb.toString());

			return redirect(routes.Application.pentaho());

		} else {
			flash("error", "Missing file");
			return redirect(controllers.Application.pentaho().toString());
		}
	}

	/**
	 * The method for each uploaded xml file that stores the file in the filesystem,
	 * sends to the slace app and gets result of the execution.
	 * The result is stored is the "Metrics" file in the same folder
	 *
	 * @return pentaho results
	 */

	private static String executionClient ( String uploadPath, MultipartFormData.FilePart fp){
		try {
			final IStorageProvider provider = new StorageProvider();
			final String type = "xml";

			// variable for iterating the uploaded files
			StringBuffer sb = new StringBuffer();
			String fileName = fp.getFilename();
			File file = fp.getFile();

			String newDir = uploadPath + "/"
					+ fileName.substring(0, fileName.indexOf("."));
			File dir = new File(newDir);
			dir.mkdir();
			Files.write(Files.toByteArray(file), new File(newDir,
					fileName));

			// sending the file to url
			RoundRobin rR = new RoundRobin();

			final Integer[] NO_INTS = new Integer[0];
			int [] initArray;
			int [] preInitArray;
			Map<Integer, ArrayList<Double>> dataUtilArray;
			String result = null;
			String name = "";

			for (TestFlow tf:TestFlows.values()){				
				if (tf.getFileName() == null){continue;}
				if (tf.getFileName().equals(fileName)) {
					name = Integer.toString(tf.getFlowId());
					initArray = ArrayUtils.toPrimitive(tf.getInitUtils().toArray(NO_INTS));
					preInitArray = ArrayUtils.toPrimitive(tf.getPreInitUtils().toArray(NO_INTS));
					dataUtilArray = tf.getDataUtils();
					result = sendPost(rR.getNextURL(),file.toString(), fileName, initArray, preInitArray, dataUtilArray);
				}
			}

			sb.append(result).append("\n");
			byte[] b = sb.toString().getBytes(Charset.forName("UTF-8"));
			System.out.println(fileName);

			String MName = Machines.values()[0].getMachineName().toString();
			//String name = "Metrics";
			String extension = ".csv";
			//String UniquetimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			long timeStamp = System.currentTimeMillis() / 1000L;
			String uniquetimeStamp = Objects.toString(timeStamp, null);

			String metricsPath = Play.application().configuration().getString("metricsPath");


			CSVWriter writer = new CSVWriter(new FileWriter(metricsPath+"/"+name+"-"+MName+"-"+uniquetimeStamp+extension), '\t');

			//Create record

			String[] metrics = sb.toString().split("\t");

			//Write the record to file
			for (int i = 0; i < metrics.length; i++) {
				if (i == 0) {
					continue;
				}
				String[] line = metrics[i].split(",");

				/*IStorage storage = provider.getStorage(type);

				storage.setStepName(line[0]);
				storage.setCopyNumber(Integer.valueOf(line[1]));
				storage.setReadNumber(Integer.valueOf(line[2]));
				storage.setWriteNumber(Integer.valueOf(line[3]));
				storage.setInputNumber(Integer.valueOf(line[4]));
				storage.setOutputNumber(Integer.valueOf(line[5]));
				storage.setUpdated(Integer.valueOf(line[6]));
				storage.setRejected(Integer.valueOf(line[7]));
				storage.setStatus(line[8]);
				storage.setRuntime(Integer.valueOf(line[9]));
				storage.setFileName(metricsPath + "/" + name + "-" + MName + "-" + uniquetimeStamp + ".xml");
				storage.save();*/

				writer.writeNext(line);
			}

			//close the writer
			writer.close();

			//Files.write(b, new File(newDir, "Metrics"));
			return result;
			// return redirect(routes.Application.pentaho());
		} catch (IOException ex) {
			flash("error", ex.getMessage());
			return ("error");
		}
	}
	/**
	 * method that sends request to pentaho slave; receives the results and returns them in form of a string
	 *
	 * @param url
	 *            client url
	 * @param data
	 *            xml content of the file
	 * @return result time of kettle execution
	 */
	private static String sendPost(String url, String data, String fileName, int[] initUtilArray, int[] preInitUtilArray, Map<Integer, ArrayList<Double>> dataUtilArray) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		String result = "empty result";

		JSONObject dataToSend = new JSONObject();
		try {
			dataToSend.put("FName", fileName);
			dataToSend.put("data", data);
			dataToSend.put("initUtilArrayLength", Integer.toString(initUtilArray.length));
			for (int i = 0; i < initUtilArray.length; i++) {
				dataToSend.put("initUtilArray["+i+"]", Integer.toString(initUtilArray[i]));
			}
			// ETLs, that need to be executed before preinitialization of the current ETL
			dataToSend.put("preInitUtilArrayLength", Integer.toString(preInitUtilArray.length));
			for (int i = 0; i < preInitUtilArray.length; i++) {
				dataToSend.put("preInitUtilArray["+i+"]", Integer.toString(preInitUtilArray[i]));
			}
			dataToSend.put("dataUtilETLLength", Integer.toString(preInitUtilArray.length));
			for (int i = 0; i < preInitUtilArray.length; i++) {
				dataToSend.put("preInitUtilArray["+i+"]", Integer.toString(preInitUtilArray[i]));
			}
			dataToSend.put("DataUtils", dataUtilArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("data = "+dataToSend);


		try {
			//System.out.println("sendPost(): " + "data: " + data);
			HttpPost httpPost = new HttpPost(url);
			/*List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
			// Uploaded ETL name
			nvps.add(new BasicNameValuePair("FName", fileName));
			// Uploaded ETL
			nvps.add(new BasicNameValuePair("data", data));			
			// ETLs, that need to be executed before initialization of the current ETL
			nvps.add(new BasicNameValuePair("initUtilArrayLength", Integer.toString(initUtilArray.length)));
			for (int i = 0; i < initUtilArray.length; i++) {
				nvps.add(new BasicNameValuePair("initUtilArray[]", Integer.toString(initUtilArray[i])));
	        }
			// ETLs, that need to be executed before preinitialization of the current ETL
			nvps.add(new BasicNameValuePair("preInitUtilArrayLength", Integer.toString(preInitUtilArray.length)));
			for (int i = 0; i < preInitUtilArray.length; i++) {
				nvps.add(new BasicNameValuePair("preInitUtilArray[]", Integer.toString(preInitUtilArray[i])));
	        }
			httpPost.setHeader(HTTP.CONTENT_TYPE,
					"application/x-www-form-urlencoded;charset=UTF-8");
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			System.out.println("nvps data = "+nvps);
			 */


			response().setHeader("Access-Control-Allow-Origin", "*");
			response().setHeader("Cache-Control", "no-cache");

			httpPost.setHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8");

			StringEntity entity = new StringEntity(dataToSend.toString());
			httpPost.setEntity(entity);
			System.out.println("entity = "+httpPost.getEntity());
			//System.out.println("1:" + httpPost.getParams());
			response = httpclient.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			//System.out.println("2:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("Response content length: "
						+ responseEntity.getContentLength());
			}

			result = EntityUtils.toString(responseEntity);
		} catch (ClientProtocolException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	/**
	 * method for resolves the client url according to round robin algorithm
	 *
	 * @param count
	 *            number of the files
	 * @param i
	 *            current file id
	 * @return client url for current executing file




    private static String getNextUrl(int count, int i) {
        // two urls to running clients
        List<String> servers = Arrays.asList("http://localhost:9002/pentaho",
                "http://localhost:9003/pentaho");
        if ((count >= servers.size() && i < servers.size())
                || (count < servers.size())) {
            return servers.get(i);
        } else if (count >= servers.size() && i >= servers.size()) {
            return servers.get(i - (count - servers.size()));
        } else {
            return servers.get(0);
        }
    }*/

	public static Result checkPreFlight() {
		response().setHeader("Access-Control-Allow-Origin", "*");
		response().setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, PUT, DELETE");
		response().setHeader("Access-Control-Max-Age", "300");
		response().setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		return ok();
	}



	@Component
	public class SimpleCORSFilter implements Filter {

		public void doFilter(ServletRequest req, ServletResponse res,
				FilterChain chain) throws IOException, ServletException {
			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods",
					"POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers",
					"x-requested-with");
			chain.doFilter(req, res);
		}

		public void init(FilterConfig filterConfig) {
		}

		public void destroy() {
		}

	}
}



