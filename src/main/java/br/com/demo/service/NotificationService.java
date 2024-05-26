package br.com.demo.service;

import br.com.demo.config.AppPropertiesConfig;
/*import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;*/
import br.com.demo.controller.request.MessageRequest;
import br.com.demo.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final AppPropertiesConfig appPropertiesConfig;
    private final SnsClient snsClient;

    public String publish(MessageRequest messageRequest) {

        PublishRequest publishRequest = PublishRequest.builder()
            .topicArn(appPropertiesConfig.getSnsTopicDemoArn())
            .message(JsonUtils.toJson(messageRequest.getMessage()))
            .build();

        return snsClient.publish(publishRequest).messageId();
    }
}
