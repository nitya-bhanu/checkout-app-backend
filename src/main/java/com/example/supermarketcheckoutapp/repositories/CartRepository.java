package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart,String> {
}
