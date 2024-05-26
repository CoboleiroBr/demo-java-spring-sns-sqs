package br.com.demo.sqs;

import br.com.demo.controller.request.MessageRequest;
import br.com.demo.sqs.model.TopicMessage;
import br.com.demo.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsListener {

    @JmsListener(destination = "${app.aws.sqs.queue.demo.name}")
    public void receiveMessage(String content) {
        log.info("Mensagem recebida do SQS: " + getConnectionMessage(content));
    }

    private String getConnectionMessage(String content) {
        TopicMessage topicMessage = JsonUtils.fromJson(content, TopicMessage.class);
        return JsonUtils.fromJson(topicMessage.getMessage(), MessageRequest.class).getMessage();
    }
}
