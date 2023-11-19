package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.domains.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{emailId: ?0}")
    User findByfields(String emailId);

}
