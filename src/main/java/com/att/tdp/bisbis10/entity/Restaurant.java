package com.att.tdp.bisbis10.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int averageRating;
    private boolean isKosher;
    private String[] cuisines;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Dish> dishes = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name, int averageRating, boolean isKosher, String[] cuisines) {
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public String[] getCuisines() {
        return cuisines;
    }

    public void setCuisines(String[] cuisines) {
        this.cuisines = cuisines;
    }

    public List<Dish> getDishs() {
        return dishes;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishes = dishs;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setRestaurant(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.setRestaurant(null);
    }

}
