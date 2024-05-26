package br.com.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppPropertiesConfig {

    @Value("${app.aws.region}")
    private String awsRegion;

    @Value("${app.aws.endpoint-url:}")
    private String awsEndpointUrl;

    @Value("${app.aws.accessKeyId:}")
    private String awsAccessKeyId;

    @Value("${app.aws.secretKey:}")
    private String awsSecretKey;

    @Value("${app.aws.sqs.queue.demo.name}")
    private String awsSqsQueueDemoName;

    @Value("${app.aws.sns.topic.demo.arn}")
    private String snsTopicDemoArn;
}
