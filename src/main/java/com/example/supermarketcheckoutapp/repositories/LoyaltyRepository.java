package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Loyalty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoyaltyRepository extends MongoRepository<Loyalty,String> {
}
