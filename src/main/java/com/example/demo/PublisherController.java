package com.example.demo;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


// https://dzone.com/articles/bootiful-gcp-spring-cloud-stream-with-google-cloud
@RestController
public class PublisherController {

    private final MessageChannel outgoing;

    public PublisherController(Channels channels) {
        outgoing = channels.outgoing();
    }
    @PostMapping("/publish/{name}")
    public void publish(@PathVariable String name) {
        outgoing.send(MessageBuilder.withPayload("Hello " + name + "!").build());
    }
}