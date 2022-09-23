package com.example.catalogservice.repository;

import com.example.catalogservice.domain.Food;
import com.example.catalogservice.domain.FoodRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodRestaurantRepository extends JpaRepository<FoodRestaurant, Long> {

//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);

    @Query("SELECT f FROM FoodRestaurant f WHERE ((f.restaurant_id) = :restaurant_id) and f.food_id=:food_id")
    public Food getRestFoods(@Param("restrurant_id") Long restrurant_id, @Param("food_id") Long food_id);
}
