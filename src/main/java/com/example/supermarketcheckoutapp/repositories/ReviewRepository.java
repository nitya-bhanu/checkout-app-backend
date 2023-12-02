package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Reviews,String> {
}
