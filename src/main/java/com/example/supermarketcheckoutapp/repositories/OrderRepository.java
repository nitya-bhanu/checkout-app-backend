package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
