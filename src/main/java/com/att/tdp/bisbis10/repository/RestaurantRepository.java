package com.att.tdp.bisbis10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import java.util.*;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT r FROM Restaurant r WHERE :cuisine IN (r.cuisines)")
    List<Restaurant> findByCuisine(@Param("cuisine") String cuisine);
}
