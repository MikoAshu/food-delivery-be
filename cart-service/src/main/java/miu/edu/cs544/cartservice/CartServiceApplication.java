package miu.edu.cs544.cartservice;

import miu.edu.cs544.cartservice.Domain.Cart;
import miu.edu.cs544.cartservice.Service.CartService;
import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
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
public class CartServiceApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Autowired
    CartService cartService;

    private final Logger logger = LoggerFactory.getLogger(CartServiceApplication.class);

    public static void main(String[] args){
        SpringApplication.run(CartServiceApplication.class, args);
    }
    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }
    @Bean
    public NewTopic topic() {
        return new NewTopic("events.new", 10, (short) 1);
    }

    @KafkaListener(id = "topic", topics = "user.service.newuser")
    public void listen(String in) {
        logger.info("Received: " + in);
        Integer id = Integer.parseInt(in);
        cartService.createCart(new Cart(id));
    }
//    @KafkaListener( topics = "user.service.newuser")
//    public void dltListen(String in) {
//            System.out.println(in);
//            Long id = Long.parseLong(in);
//            cartService.createCart(new Cart(id));
//    }
}
