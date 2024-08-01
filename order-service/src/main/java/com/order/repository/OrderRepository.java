package com.order.repository;

import com.order.models.Order;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;


@MongoRepository(databaseName = "orders")
public interface OrderRepository extends CrudRepository<Order, String> {
}
