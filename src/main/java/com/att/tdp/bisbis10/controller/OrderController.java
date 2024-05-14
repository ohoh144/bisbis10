package com.att.tdp.bisbis10.controller;

import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.Orders;
import com.att.tdp.bisbis10.entity.OrderRequest;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.OrderRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;

    public OrderController(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/order")
    public String saveOrders(@RequestBody OrderRequest orderRequest) {
        Restaurant restaurant = restaurantRepository.findById(orderRequest.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Restaurant not found with id: " + orderRequest.getRestaurantId()));

        Orders order = new Orders();
        order.setRestaurant(restaurant);

        order.setOrderItems(orderRequest.getOrderItems());

        return orderRepository.save(order).getId().toString();

    }

}
