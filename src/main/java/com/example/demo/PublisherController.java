package com.example.demo;

import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PublisherController {

    private final PubSubTemplate pubSubTemplate;

    public PublisherController(  PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }
    @PostMapping("/publish/{name}")
    public void publish(@PathVariable String name) {
        pubSubTemplate.publish("reservations","Hello " + name + "!");
    }
}