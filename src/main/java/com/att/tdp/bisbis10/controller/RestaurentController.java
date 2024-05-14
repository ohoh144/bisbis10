package com.att.tdp.bisbis10.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.services.RestaurentService;

@RestController
@RequestMapping("/restaurants")
public class RestaurentController {

    private final RestaurentService restaurentService;

    public RestaurentController(RestaurentService restaurentService) {
        this.restaurentService = restaurentService;
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(value = "cuisine", required = false) String cuisine) {
        if (cuisine != null){
            List<Restaurant> restaurants = restaurentService.getByCuisine(cuisine);
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
        
        List<Restaurant> restaurants = restaurentService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer id) {
        Restaurant restaurant = restaurentService.getRestaurantById(id);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurentService.saveRestaurant(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Integer id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurentService.updaRestaurant(id, updatedRestaurant);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) {
        restaurentService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
