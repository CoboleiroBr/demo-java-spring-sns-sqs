package br.com.demo.config;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
@RequiredArgsConstructor
@Profile("local")
public class AwsLocalConfig {

    private final AppPropertiesConfig appPropertiesConfig;

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
            .region(Region.of(appPropertiesConfig.getAwsRegion()))
            .endpointOverride(URI.create(appPropertiesConfig.getAwsEndpointUrl()))
            .build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
            .region(Region.of(appPropertiesConfig.getAwsRegion()))
            .endpointOverride(URI.create(appPropertiesConfig.getAwsEndpointUrl()))
            .build();
    }
}
