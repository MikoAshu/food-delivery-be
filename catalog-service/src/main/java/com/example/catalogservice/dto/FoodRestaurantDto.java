package com.example.catalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodRestaurantDto {
    private Long id;
    private FoodDto food;
    private RestaurantDto restaurant;
    private double price;

}
