package com.serviceum.service;

import com.serviceum.models.Order;
import com.serviceum.repository.OrderRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;


@Singleton
public class OrderService {

    @Inject
    private OrderRepository orderRepository;


    public List<Order> list(){
        return orderRepository.findAll();
    }

    public Order addTables(Order tables){
        return orderRepository.save(tables);

    }

}
