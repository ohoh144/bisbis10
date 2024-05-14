package com.att.tdp.bisbis10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.att.tdp.bisbis10.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findByRestaurantId(Integer restaurantId);
    
}
