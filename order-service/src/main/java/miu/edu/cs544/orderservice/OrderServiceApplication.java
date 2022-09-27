package miu.edu.cs544.orderservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
@EnableKafka
public class OrderServiceApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("events.new", 1, (short) 1);
    }

    private final Logger logger = LoggerFactory.getLogger(OrderServiceApplication.class);

    @KafkaListener(id= "topic-1" ,topics = "events.new")
    public void listen(String myMessages) {
        logger.info("Received: " + myMessages);

    }

}
