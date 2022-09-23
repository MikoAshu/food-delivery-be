package com.example.catalogservice.service;


import com.example.catalogservice.domain.FoodRestaurant;
import com.example.catalogservice.dto.FoodRestaurantDto;
import com.example.catalogservice.repository.FoodRestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class FoodRestaurantService {

    @Autowired
    FoodRestaurantRepository foodRestaurantRepository;

    public FoodRestaurantDto getrestfood(Long food_id, Long resturant_id){
        FoodRestaurant foodRestaurant = foodRestaurantRepository.findFoodRestaurantByFoodAndRestaurant(food_id, resturant_id);
        ModelMapper modelMapper = new ModelMapper();
        FoodRestaurantDto foodRestaurantDTO = modelMapper.map(foodRestaurant, FoodRestaurantDto.class);
        return foodRestaurantDTO;
    }

    public void addrestfoods(FoodRestaurant foodRestaurant){
        foodRestaurantRepository.save(foodRestaurant);
    }
}
