package com.example.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String resturnat_type;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<FoodRestaurant> foodRestaurantList;
//    @Range(min = 1, max = 5)
    private float rating;

    public Restaurant(String location, String resturnat_type, float rating) {
        this.location = location;
        this.resturnat_type = resturnat_type;
        this.rating = rating;
        this.foodRestaurantList = new ArrayList<>();
    }
    public boolean addFoodRestaurant(FoodRestaurant foodRestaurant){
        this.foodRestaurantList.add(foodRestaurant);
        return true;
    }
}
