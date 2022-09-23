package com.example.catalogservice.controller;


import com.example.catalogservice.service.FoodRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodRestaurant {
    @Autowired
    FoodRestaurantService foodRestaurantService;

    @GetMapping("/getrestFoods/{restrurant_id}/{food_id}")
    public ResponseEntity<?> getrestFoods(@PathVariable Long restrurant_id, @PathVariable Long food_id){
        return new ResponseEntity<>(foodRestaurantService.getrestfood(restrurant_id, food_id), HttpStatus.OK);
    }
//    @PostMapping("/addrestfoods")
//    public ResponseEntity<?> addrestfoods(@RequestBody FoodRestaurant foodRestaurant){
//
//        return new ResponseEntity<>(foodRestaurantService.addrestfoods(foodRestaurant));
//    }
}
