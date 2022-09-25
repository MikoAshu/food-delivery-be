package com.example.catalogservice.controller;


import com.example.catalogservice.domain.FoodRestaurant;
import com.example.catalogservice.dto.FoodRestaurantDto;
import com.example.catalogservice.service.FoodRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class FoodRestaurantController {
    @Autowired
    FoodRestaurantService foodRestaurantService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/getrestFoods/{restrurant_id}/{food_id}")
    public ResponseEntity<FoodRestaurantDto> getrestFoods(@PathVariable Long restrurant_id, @PathVariable Long food_id){
        FoodRestaurantDto foodRestaurantDto = foodRestaurantService.getrestfood(restrurant_id, food_id);
        if(foodRestaurantDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Food and Restaurant accessed "+foodRestaurantDto.toString()+" Accessed at "+timestamp2);
        return new ResponseEntity<>(foodRestaurantDto, HttpStatus.OK);
    }
    @PostMapping("/addrestfoods")
    public ResponseEntity<?> addrestfoods(@RequestBody FoodRestaurant foodRestaurant){
        foodRestaurantService.addrestfoods(foodRestaurant);

        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Food and Restaurant Added "+foodRestaurant.toString()+" Accessed at "+timestamp2);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
