package com.example.catalogservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FoodRestaurantDto {
    private Long id;
    private FoodDto food;
    private RestaurantDto restaurant;
    private double price;

}
