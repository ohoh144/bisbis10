package com.att.tdp.bisbis10.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/restaurants/{id}/dishes")
    public Dish saveDish(
        @PathVariable Integer id,
        @RequestBody Dish dish
    ) {
        return dishService.saveDish(dish, id);
    }

    @PutMapping("/restaurants/{id}/dishes/{dishId}")
    public Dish updateDish(@PathVariable Integer dishId, @RequestBody Dish dish, @PathVariable Integer id) {
        return dishService.updateDish(dishId, dish, id);
    }

    @DeleteMapping("/restaurants/{id}/dishes/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer id, @PathVariable Integer dishId){
        dishService.deleteDish(dishId, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/restaurants/{id}/dishes")
    public List<Dish> getAllDishesByRestaurant(@PathVariable Integer id) {
        return dishService.getAllDishes(id);
    }
    

}
