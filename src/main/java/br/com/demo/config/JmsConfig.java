package br.com.demo.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
@EnableJms
public class JmsConfig {

    private final SQSConnectionFactory sqsConnectionFactory;

    @Autowired
    public JmsConfig(SqsClient sqsClient) {
        this.sqsConnectionFactory = createSqsConnectionFactory(sqsClient);
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(sqsConnectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate() {
        return new JmsTemplate(sqsConnectionFactory);
    }

    private SQSConnectionFactory createSqsConnectionFactory(SqsClient sqsClient) {
        return new SQSConnectionFactory(new ProviderConfiguration(), sqsClient);
    }
}
