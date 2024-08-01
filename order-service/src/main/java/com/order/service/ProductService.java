package com.order.service;

import com.order.models.Product;
import com.order.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    public List<Product> findAll (){
        return productRepository.findAll();
    }
    
    public Product addProduct (Product product){
        return productRepository.save(product);
    }

}
