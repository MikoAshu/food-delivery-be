package com.example.catalogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private Long id;
    private String location;
    private String resturnat_type;
    private List<FoodRestaurantDto> foodRestaurantList;
    private float rating;

}
