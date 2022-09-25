package com.example.catalogservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantDto {

    private Long id;
    private String location;
    private String resturnat_type;
    private List<FoodRestaurantDto> foodRestaurantList;
    private float rating;

}
