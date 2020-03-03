package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableBinding(Channels.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner cli(PubSubTemplate pubSubTemplate) {
		return (args) -> {
			pubSubTemplate.subscribe("reservations",
					(msg, ackConsumer) -> {
						System.out.println(msg.getData().toStringUtf8());
						ackConsumer.ack();
					});
		};
	}

}
