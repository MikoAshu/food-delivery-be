package com.example.catalogservice.service;


import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.FoodRestaurant;
import com.example.catalogservice.repository.FoodRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FoodRestaurantService {

    @Autowired
    FoodRestaurantRepository foodRestaurantRepository;

    public FoodRestaurant getrestfood(Long resturant_id, Long food_id){
        return foodRestaurantRepository.findFoodRestaurantByFood_idAndRestaurant_id(resturant_id, food_id);
    }

    public void addrestfoods(FoodRestaurant foodRestaurant){
        foodRestaurantRepository.save(foodRestaurant);
    }
}
