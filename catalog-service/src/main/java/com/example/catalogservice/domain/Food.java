package com.example.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "food",cascade = CascadeType.ALL)
    private List<FoodRestaurant> foodRestaurant;
    public Food(String name, String food_type) {
        this.name = name;
        this.food_type = food_type;
        this.foodRestaurant = new ArrayList<>();
    }
    public boolean addFoodRestaurant(FoodRestaurant foodRestaurant){
        this.foodRestaurant.add(foodRestaurant);
        return true;
    }
}
