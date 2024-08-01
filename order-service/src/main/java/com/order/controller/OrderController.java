package com.order.controller;

import com.order.models.Order;
import com.order.service.OrderService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("orders")
public class OrderController {

    @Inject
    private OrderService orderService;

    @Get("list")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @Post("addOrder")
    public Order addOrder (@Body Order order){
        return orderService.addOrder(order);
    }

}
