package com.example.catalogservice.intergation;

import com.example.catalogservice.dto.FoodDto;
import com.example.catalogservice.dto.FoodRestaurantDto;
import com.example.catalogservice.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaffkaFoodSender {
    @Autowired
    private KafkaTemplate<String, List<FoodDto>> kafkaTemplate1;
    @Autowired
    private KafkaTemplate<String, RestaurantDto> kafkaTemplate2;
    @Autowired
    private KafkaTemplate<String, FoodRestaurantDto> kafkaTemplate3;
    @Autowired
    private KafkaTemplate<String, FoodDto> kafkaTemplate4;
    private String topic1 = "ListOfFoodTopic";
    private String topic2 = "RestaurantTopic";
    private String topic3 ="FoodRestaurantTopic";
    private String topic4 ="FoodTopic";


    public void sendListOfFoodDtos(List<FoodDto> foodDto){
        System.out.println("**************************************************");
        System.out.println("Sending List of Food Dtos" + foodDto.toString());
        System.out.println("**************************************************");
        kafkaTemplate1.send(topic1,foodDto);
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
    public void sendFoodDtos(FoodDto foodDto){
        System.out.println("**************************************************");
        System.out.println("Sending Food Dto" + foodDto.toString());
        System.out.println("**************************************************");
        kafkaTemplate4.send(topic4,foodDto);
    }
}
