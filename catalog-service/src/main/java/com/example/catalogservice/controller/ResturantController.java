package com.example.catalogservice.controller;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.Restaurant;
import com.example.catalogservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController("/resturant")
public class ResturantController {
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @PostMapping("/addRestruant")
    public ResponseEntity<Restaurant> addRestruant(@RequestBody Restaurant restaurant){
         restaurantService.addRestaurant(restaurant);

        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Restaurant Added"+restaurant.toString()+"Added time"+timestamp2);

        return new ResponseEntity<Restaurant>(HttpStatus.OK);
    }
}
