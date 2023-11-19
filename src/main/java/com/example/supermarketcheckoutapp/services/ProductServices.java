package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;

    public void postProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductsByID(String prodId) throws Exception{
        Optional<Product> product=productRepository.findById(prodId);
            if(product.isEmpty()) {
                throw new Exception();
            }
            return product.get();
    }

    public List<Product> getAllProducts(int pageIndex,int pageSize,String sortDirection,String criteriaName,String categoryName,String searchQuery){
        List<Product>products= productRepository.findAll();
        int len= Math.min(products.size(), pageSize);
        Pageable pageable;
        if(Objects.equals(sortDirection, "none")){
            pageable=PageRequest.of(pageIndex,len);
        }
        else
        {
            if(sortDirection.equals("asc"))
                pageable=PageRequest.of(pageIndex,len,Sort.by(Sort.Direction.ASC,criteriaName));
            else
                pageable=PageRequest.of(pageIndex,len,Sort.by(Sort.Direction.DESC,criteriaName));
        }
        if(categoryName.isEmpty() && !searchQuery.isEmpty())
        {
            System.out.println("first check");
            return productRepository.findOnlyBySearchfields(searchQuery,pageable);
        }
        else if(searchQuery.isEmpty() && !categoryName.isEmpty()) {
            System.out.println("second check");
            return productRepository.findOnlyByCategoryfields(categoryName,pageable);
        }
        else if(!searchQuery.isEmpty()){
            System.out.println("third check");
            return productRepository.findByfields(categoryName, searchQuery, pageable);
        }
        else
            return productRepository.findAll(pageable).getContent();
    }
    public void deleteProductsByID(String prodId){
        productRepository.deleteById(prodId);
    }

    public void updateProductsByID(String prodId, Product prod) throws Exception{
        Optional<Product> product=productRepository.findById(prodId);
        if(product.isEmpty()){
            System.out.println("Not found");
            throw new Exception();
        }
        productRepository.save(prod);
    }
}
