package com.att.tdp.bisbis10.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;

@Service
public class DishService {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Dish saveDish(Dish dish, Integer restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            dish.setRestaurant(restaurant.get());
            return dishRepository.save(dish);
        }

        return null;

    }

    public Dish updateDish(Integer dishId, Dish dish, Integer restaurantId) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if (restaurant.isPresent()) {
            Optional<Dish> isDishPresent = dishRepository.findById(dishId);

            if (isDishPresent.isPresent()) {
                dish.setRestaurant(restaurant.get());
                return dishRepository.save(dish);
            }

            return null;
        }

        return null;

    }

    public void deleteDish(Integer id, Integer restuarantId) {

        Optional<Restaurant> restauranOptional = restaurantRepository.findById(restuarantId);

        if (restauranOptional.isPresent()) {
            dishRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Dish not found with id: " + id));

            dishRepository.deleteById(id);
        }

    }

    public List<Dish> getAllDishes(Integer restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

}
