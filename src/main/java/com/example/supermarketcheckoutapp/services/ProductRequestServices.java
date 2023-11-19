package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.ProductRequest;
import com.example.supermarketcheckoutapp.repositories.ProductRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRequestServices {
    private final ProductRequestRepository productRequestRepository;

    public String saveProductRequest(ProductRequest productRequest){
        productRequestRepository.save(productRequest);
        return "Product Saved successfully";
    }
    public List<ProductRequest> getProductRequest(){
        return productRequestRepository.findAll();
    }
}
