package com.example.supermarketcheckoutapp.repositories;

import com.example.supermarketcheckoutapp.domains.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{category: ?0,title: {$regex: ?1,$options:'i'}}")
    List<Product> findByfields(String categoryName, String searchQuery, Pageable pageable);

    @Query("{title: {$regex: ?0,$options:'i'}}")
    List<Product> findOnlyBySearchfields(String searchQuery, Pageable pageable);

    @Query("{category: ?0}")
    List<Product> findOnlyByCategoryfields(String categoryName, Pageable pageable);
}
