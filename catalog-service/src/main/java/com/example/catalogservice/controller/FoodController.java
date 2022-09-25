package com.example.catalogservice.controller;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.Restaurant;
import com.example.catalogservice.dto.FoodDto;
import com.example.catalogservice.intergation.KaffkaFoodSender;
import com.example.catalogservice.service.FoodService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.sql.Timestamp;


@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/getfoods")
    public ResponseEntity<List<FoodDto>> getfoods(){
        List<FoodDto> foodsdtos= foodService.getFoods();
        if (foodsdtos==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "List of Foods Accessed  "+foodsdtos.toString()+"Accessed at"+timestamp2);

        return new ResponseEntity<>(foodsdtos, HttpStatus.OK);
    }

    @GetMapping("/getfoods/{food_id}")
    public ResponseEntity<FoodDto> getfood(@PathVariable Long food_id){
        FoodDto food = foodService.getFood(food_id);
        if (food==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", " Food Accessed "+food.toString()+" Accessed at "+timestamp2);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
    @PostMapping("/addfood")
    public ResponseEntity<?> addFood(@RequestBody Food food){
        foodService.addfood(food);
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Food Added "+food.toString()+" Added at "+timestamp2);
        return new ResponseEntity<>("Food created successfully", HttpStatus.OK);
    }
}
