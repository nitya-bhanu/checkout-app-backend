package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Order;
import com.example.supermarketcheckoutapp.domains.ProductRequest;
import com.example.supermarketcheckoutapp.services.ProductRequestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product_request")
public class ProductRequestController {

    @Autowired
    ProductRequestServices productRequestServices;

    @PostMapping("")
    public String saveProdRequest(@RequestBody ProductRequest productRequest){
        return productRequestServices.saveProductRequest(productRequest);
    }

    @GetMapping("")
    public List<ProductRequest> getProductRequest(){
        return productRequestServices.getProductRequest();
    }
}
