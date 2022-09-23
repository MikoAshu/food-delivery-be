package com.example.catalogservice.intergation;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.FoodRestaurant;
import com.example.catalogservice.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KaffkaSender {
    @Autowired
    private KafkaTemplate<String, Food> kafkaTemplate1;
    @Autowired
    private KafkaTemplate<String, Restaurant> kafkaTemplate2;

    @Autowired
    private KafkaTemplate<String, FoodRestaurant> kafkaTemplate3;
    private String topic = "FoodTopic";
    private String topic2 = "RestaurantTopic";
    private String topic3 ="FoodRestaurantTopic";

    public void sendFood(Food food){
        System.out.println("**************************************************");
        System.out.println("Sending Food" + food.toString());
        System.out.println("**************************************************");
        kafkaTemplate1.send(topic,food);
    }

    public void sendRestaurant(Restaurant restaurant){
        System.out.println("Sending Restaurant" + restaurant.toString());
        System.out.println("**************************************************");
        kafkaTemplate2.send(topic2,restaurant);
        System.out.println("**************************************************");
        System.out.println("Sending Restaurant" + restaurant.toString());
    }

    public void sendFoodRestaurant(FoodRestaurant foodRestaurant){
        System.out.println("**************************************************");
        System.out.println("Sending FoodRestaurant" + foodRestaurant.toString());
        kafkaTemplate3.send(topic3,foodRestaurant);
        System.out.println("**************************************************");
        System.out.println("Sending FoodRestaurant" + foodRestaurant.toString());
    }
}
