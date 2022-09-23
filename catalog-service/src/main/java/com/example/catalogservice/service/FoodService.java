package com.example.catalogservice.service;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.repository.FoodRepository;
import com.example.catalogservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Food> getFoods(){
        return foodRepository.findAll();
    }
    public Food getFood(Long foodId){
        return foodRepository.findById(foodId).get();
    }
    public Food addfood(Food food){
        foodRepository.save(food);
        return food;
    }
}
