package com.example.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodRestaurant {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Food food_id;
    @ManyToOne
    private Restaurant restaurant_id;
    private double price;

    public FoodRestaurant(Food food_id, Restaurant restaurant_id, double price) {
        this.food_id = food_id;
        this.restaurant_id = restaurant_id;
        this.price = price;
    }
}
