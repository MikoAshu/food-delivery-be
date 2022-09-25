package com.example.catalogservice.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodDto {
    private Long id;
    private String name;
    private  String food_type;
}
