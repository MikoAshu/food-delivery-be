package com.example.catalogservice.controller;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.Restaurant;
import com.example.catalogservice.dto.FoodDto;
import com.example.catalogservice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/getfoods")
    public ResponseEntity<List<FoodDto>> getfoods(){
        List<FoodDto> foodsdtos= foodService.getFoods();
        if (foodsdtos==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodsdtos, HttpStatus.OK);
    }

    @GetMapping("/getfoods/{food_id}")
    public ResponseEntity<FoodDto> getfood(@PathVariable Long food_id){
        FoodDto food = foodService.getFood(food_id);
        if (food==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
    @PostMapping("/addfood")
    public ResponseEntity<?> addFood(@RequestBody Food food){
        foodService.addfood(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}
