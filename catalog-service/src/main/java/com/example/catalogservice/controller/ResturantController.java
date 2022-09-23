package com.example.catalogservice.controller;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.Restaurant;
import com.example.catalogservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/resturant")
public class ResturantController {

    @Autowired
    RestaurantService restaurantService;


    @PostMapping("/addRestruant")
    public ResponseEntity<Restaurant> addRestruant(@RequestBody Restaurant restaurant){
         restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(HttpStatus.OK);
    }
}
