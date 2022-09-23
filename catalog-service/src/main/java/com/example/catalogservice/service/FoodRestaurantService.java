package com.example.catalogservice.service;


import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.FoodRestaurant;
import com.example.catalogservice.repository.FoodRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodRestaurantService {

    @Autowired
    FoodRestaurantRepository foodRestaurantRepository;

    public Food getrestfood(Long resturant_id, Long food_id){
        return foodRestaurantRepository.getRestFoods(resturant_id, food_id);
    }

    public void addrestfoods(FoodRestaurant foodRestaurant){
        foodRestaurantRepository.save(foodRestaurant);
    }
}
