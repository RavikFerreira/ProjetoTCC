package com.order.repository;

import com.order.models.Product;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;


@MongoRepository(databaseName = "orders")
public interface ProductRepository extends CrudRepository<Product, String> {
}
