package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.ProductRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRequestRepository extends MongoRepository<ProductRequest,String> {
}
