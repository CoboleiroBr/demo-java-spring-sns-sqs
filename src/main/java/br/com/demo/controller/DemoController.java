package br.com.demo.controller;

import br.com.demo.controller.request.MessageRequest;
import br.com.demo.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    private final NotificationService notificationService;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@Valid @RequestBody MessageRequest message) {

        try {
            var response = notificationService.publish(message);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Throwable ex) {
            log.error("Error posting a message in SNS topic");
            throw ex;
        }
    }
}
