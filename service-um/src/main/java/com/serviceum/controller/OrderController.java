package com.serviceum.controller;


import com.serviceum.models.Order;
import com.serviceum.service.OrderService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("orders/")
public class OrderController {
    @Inject
    private OrderService tableService;

    @Get("list")
    public HttpResponse<List<Order>> listOrders(){
        return HttpResponse.ok(tableService.list());
    }

    @Post("create")
    public HttpResponse<Order> addTables(@Body Order order){
        Order orders = tableService.addTables(order);
        return HttpResponse.created(orders);
    }
}
