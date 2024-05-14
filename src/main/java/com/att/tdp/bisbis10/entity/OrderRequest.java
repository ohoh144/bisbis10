package com.att.tdp.bisbis10.entity;

import java.util.List;

public class OrderRequest {

    private int restaurantId;
    private List<OrderItem> orderItems;

    public OrderRequest(int restaurantId, List<OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }
    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    
    
}
