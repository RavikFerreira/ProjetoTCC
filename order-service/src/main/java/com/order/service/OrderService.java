package com.order.service;

import com.order.models.Order;
import com.order.repository.OrderRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public List<Order> findAll (){
        return orderRepository.findAll();
    }

    public Order addOrder (Order order){
        return orderRepository.save(order);
    }

}
