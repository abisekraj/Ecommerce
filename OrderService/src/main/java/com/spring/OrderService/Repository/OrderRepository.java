package com.spring.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.OrderService.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
