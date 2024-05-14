package com.att.tdp.bisbis10.controller;

import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.entity.RatingData;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RatingController {

    private RatingRepository ratingRepository;
    private RestaurantRepository restaurantRepository;

    public RatingController(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/ratings")
    public Rating saveRating(@RequestBody RatingData ratingdData) {

        // Find the restaurant by ID
        Restaurant restaurant = restaurantRepository.findById(ratingdData.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found with id: " + ratingdData.restaurantId()));

        // Create a new Rating object
        Rating rating = new Rating();
        rating.setRating(ratingdData.rating());
        rating.setRestaurant(restaurant);

        return ratingRepository.save(rating);
    }
    
    
}
