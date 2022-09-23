package com.example.catalogservice.service;

import com.example.catalogservice.domain.Restaurant;
import com.example.catalogservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    public RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
}
