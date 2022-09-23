package com.example.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private  String food_type;

    public Food(String name, String food_type) {
        this.name = name;
        this.food_type = food_type;
    }
}
