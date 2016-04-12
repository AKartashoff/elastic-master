package storage;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "metrics_result")
public class MetricsResultXML implements IStorage {

	@XmlElement(name = "step_name")                                                                  
	private String stepName;

	@XmlElement (name = "copy_nr")                                                                       
	private Integer copyNumber;

	@XmlElement (name = "read_nr")                                                                       
	private Integer readNumber;

	@XmlElement (name = "write_nr")                                                                       
	private Integer writeNumber;

	@XmlElement (name = "input_nr")                                                                       
	private Integer inputNumber;

	@XmlElement (name = "output_nr")                                                                       
	private Integer outputNumber;

	@XmlElement (name = "updated")                                                                       
	private Integer updated;

	@XmlElement (name = "rejected")                                                                       
	private Integer rejected;

	@XmlElement (name = "errors")                                                                       
	private Integer errors;

	@XmlElement (name = "status")                                                                       
	private String status;

	@XmlElement (name = "runtime")                                                                       
	private Integer runtime;
	
	@XmlElement (name = "machineId")                                                                       
	private Integer machineID;
	
	@XmlElement (name = "timestamp")                                                                       
	private String timestamp;
	
	@XmlElement (name = "flowId")                                                                       
	private String flowId;
	
	private String fileName;
	
	@Override
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	@Override
	public void setCopyNumber(Integer copyNumber) {
		this.copyNumber = copyNumber;
	}

	@Override
	public void setReadNumber(Integer readNumber) {
		this.readNumber = readNumber;
	}

	@Override
	public void setWriteNumber(Integer writeNumber) {
		this.writeNumber = writeNumber;
	}

	@Override
	public void setInputNumber(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}

	@Override
	public void setOutputNumber(Integer outputNumber) {
		this.outputNumber = outputNumber;
	}

	@Override
	public void setUpdated(Integer updated) {
		this.updated = updated;
	}

	@Override
	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	@Override
	public void setErrors(Integer errors) {
		this.errors = errors;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	
	@Override
	public void setFileName(String name) {
		this.fileName = name;
	}
	
	@Override
	public void setMachineId(Integer machineID) {
		this.machineID = machineID;
	}
	@Override
	public void setTimeStamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	@Override
	public void save() {
		try {
			File file = new File(this.fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(MetricsResultXML.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this, file);
		} catch (JAXBException e) {
			System.err.println(e.getMessage());
		}
	}
}
