package com.example.Log;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@SpringBootApplication
@EnableKafka
public class LogApplication {

	@Autowired
	LogService logService;
	private final Logger logger = LoggerFactory.getLogger(LogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
	}

	@Bean
	public RecordMessageConverter converter() {
		return new JsonMessageConverter();
	}
	@Bean
	public NewTopic topic() {
		return new NewTopic("events.new", 10, (short) 1);
	}

	@KafkaListener(groupId = "food",topics = "events.new")
	public void listen(String something) {
		logger.info("Received: " + something);
		logService.addToRepostiory(something);
	}
}
