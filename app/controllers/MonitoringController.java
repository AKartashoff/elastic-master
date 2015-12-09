package controllers;

import java.util.Date;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
/**
 * class for ec2 metrics monitoring.
 * method getMeasures takes as arguments Access key, security key and instanceID of the desired Amazon EC2 instance
 * method client of the AmazonCloudWatchClient creates a monitoring point
 * method request of the GetMetricStatisticsRequest makes a request to get defined metrics in the defined period of time
 * (Vasileios, please mention the metrics that you'd like to get in the future)
 *
 * method toStdOut prints the result (It may be changed, so it will return the desired metrics)
 */
public class MonitoringController  {
    public static void getMeasures(final String awsAccessKey, final String awsSecretKey, final String instanceId) {
        /*final String awsAccessKey = "AKIAJZMBVRZ3MKD43VJQ";
        final String awsSecretKey = "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";
        final String instanceId = "i-253685e4";*/

        final AmazonCloudWatchClient client = client(awsAccessKey, awsSecretKey);
        final GetMetricStatisticsRequest request = request(instanceId);
        final GetMetricStatisticsResult result = result(client, request);
        toStdOut(result, instanceId);

    }

    private static AmazonCloudWatchClient client(final String awsAccessKey, final String awsSecretKey) {
        final AmazonCloudWatchClient client = new AmazonCloudWatchClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        client.setEndpoint("http://monitoring.eu-central-1.amazonaws.com");
        return client;
    }

    private static GetMetricStatisticsRequest request(final String instanceId) {
        final long twentyFourHrs = 1000 * 60 * 60 * 24;
        final int oneHour = 60 * 60;
        return new GetMetricStatisticsRequest()
                .withStartTime(new Date(new Date().getTime()- twentyFourHrs))
                .withNamespace("AWS/EC2")
                .withPeriod(oneHour)
                .withDimensions(new Dimension().withName("InstanceId").withValue(instanceId))
                .withMetricName("CPUUtilization")
                .withStatistics("Average", "Maximum")
                .withEndTime(new Date());
    }

    private static GetMetricStatisticsResult result(
            final AmazonCloudWatchClient client, final GetMetricStatisticsRequest request) {
        return client.getMetricStatistics(request);
    }

    private static void toStdOut(final GetMetricStatisticsResult result, final String instanceId) {
        System.out.println(result);
        for (final Datapoint dataPoint : result.getDatapoints()) {
            System.out.printf("%s instance's average CPU utilization : %s%n", instanceId, dataPoint.getAverage());
            System.out.printf("%s instance's max CPU utilization : %s%n", instanceId, dataPoint.getMaximum());
        }
    }
}
