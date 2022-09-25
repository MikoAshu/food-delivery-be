package com.example.catalogservice.intergation;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.dto.FoodDto;
import com.example.catalogservice.dto.FoodRestaurantDto;
import com.example.catalogservice.dto.RestaurantDto;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class KaffkaFoodSender {
    @Autowired
    private KafkaTemplate<String, List<FoodDto>> kafkaTemplate1;
    @Autowired
    private KafkaTemplate<String, RestaurantDto> kafkaTemplate2;
    @Autowired
    private KafkaTemplate<String, FoodRestaurantDto> kafkaTemplate3;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate4;
    private String topic1 = "ListOfFoodTopic";
    private String topic2 = "RestaurantTopic";
    private String topic3 ="FoodRestaurantTopic";
    private String topic4 ="FoodTopic";
    private static final String bootstrapServers = "docker.for.mac.localhost:9092";


    public void sendListOfFoodDtos(List<FoodDto> foodDto){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

//producer record
        ProducerRecord<String, String> record = new ProducerRecord("first_topic", "hello from java");

//send data
        producer.send(record);
        System.out.println("**************************************************");
        System.out.println("Sending List of Food Dtos" + foodDto.toString());
        System.out.println("**************************************************");
//        kafkaTemplate1.send(topic1,foodDto);
    }

    public void sendRestaurantDto(RestaurantDto restaurantdto){
        System.out.println("Sending Restaurant" + restaurantdto.toString());
        System.out.println("**************************************************");
        kafkaTemplate2.send(topic2,restaurantdto);
        System.out.println("**************************************************");
        System.out.println("Sending Restaurant" + restaurantdto.toString());
    }

    public void sendFoodRestaurantdto(FoodRestaurantDto foodRestaurantDto){
        System.out.println("**************************************************");
        System.out.println("Sending FoodRestaurant" + foodRestaurantDto.toString());
        kafkaTemplate3.send(topic3,foodRestaurantDto);
        System.out.println("**************************************************");
        System.out.println("Sending FoodRestaurant" + foodRestaurantDto.toString());
    }
    public void sendFoodDtos(Food food){
        System.out.println("**************************************************");
        System.out.println("Sending Food Dto" + food.toString());
        System.out.println("**************************************************");
        kafkaTemplate4.send(topic4,food.toString());
    }
}
