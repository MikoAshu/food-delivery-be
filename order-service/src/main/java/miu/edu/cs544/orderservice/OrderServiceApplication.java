package miu.edu.cs544.orderservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
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

//    @KafkaListener( topics = "events.new")
//    public void listen(String myMessages) {
//        logger.info("Received: " + foo);
//        if (foo.getFoo().startsWith("fail")) {
//            throw new RuntimeException("failed");
//        }
//        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
//    }

}
