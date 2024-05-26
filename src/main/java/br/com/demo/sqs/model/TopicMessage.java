package br.com.demo.sqs.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicMessage {

    private String type;
    private String messageId;
    private String topicArn;
    private String message;
    private Date timestamp;
    private String signatureVersion;
    private String signature;
    private String signingCertURL;
    private String unsubscribeURL;
    private Map<String, MessageAttribute> messageAttributes;
}
