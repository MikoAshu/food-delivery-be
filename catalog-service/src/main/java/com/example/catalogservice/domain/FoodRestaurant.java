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
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodRestaurant {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Food food;
    @ManyToOne
    private Restaurant restaurant;
    private double price;

    public FoodRestaurant(Food food, Restaurant restaurant, double price) {
        this.food = food;
        this.restaurant = restaurant;
        this.price = price;
    }
}
