package com.example.catalogservice.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private Long user_id;
    private String location;
    private String resturnat_type;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<FoodRestaurant> foodRestaurantList;
    @Range(min = 1, max = 5)
    private float rating;

    public Restaurant(Long user_id,String location, String resturnat_type, float rating) {
        this.user_id = user_id;
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
