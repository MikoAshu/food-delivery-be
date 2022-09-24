package com.example.catalogservice.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodRestaurant {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Food food;
    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;
    private double price;

    public FoodRestaurant(Food food, Restaurant restaurant, double price) {
        this.food = food;
        this.restaurant = restaurant;
        this.price = price;
    }
}
