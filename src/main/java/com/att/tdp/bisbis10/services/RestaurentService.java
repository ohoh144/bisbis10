package com.att.tdp.bisbis10.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;

@Service
public class RestaurentService {

    private final RestaurantRepository restaurantRepository;

    public RestaurentService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Integer id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        return optionalRestaurant.orElseThrow(null);
    }

    public List<Restaurant> getByCuisine(String cuisine){
        return restaurantRepository.findByCuisine(cuisine);
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updaRestaurant(Integer id,Restaurant restaurant){
        Optional<Restaurant> isRestaurentPresent = restaurantRepository.findById(id);
        if(isRestaurentPresent.isPresent()){
            return restaurantRepository.save(restaurant);
        }else{
            return null;
        }
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

}
