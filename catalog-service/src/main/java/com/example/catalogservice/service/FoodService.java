package com.example.catalogservice.service;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.dto.FoodDto;
import com.example.catalogservice.repository.FoodRepository;
import com.example.catalogservice.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<FoodDto> getFoods(){
        List<Food> foods = foodRepository.findAll();
        List<FoodDto> foodDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Food food: foods){
            foodDtos.add(modelMapper.map(food, FoodDto.class));
        }
        return foodDtos;
    }
    public FoodDto getFood(Long foodId){
        Food food = foodRepository.findById(foodId).get();
        ModelMapper modelMapper = new ModelMapper();
        FoodDto foodDto = modelMapper.map(food, FoodDto.class);
        return foodDto;
    }
    public void addfood(Food food){
        foodRepository.save(food);
    }
}
