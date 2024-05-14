package com.att.tdp.bisbis10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.att.tdp.bisbis10.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    
}
