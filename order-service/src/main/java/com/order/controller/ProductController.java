package com.order.controller;

import com.order.models.Product;
import com.order.service.ProductService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("products")
public class ProductController {

    @Inject
    private ProductService productService;

    @Get("list")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Post("addProduct")
    public Product addOrder(@Body Product product) {
        return productService.addProduct(product);
    }
}