package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Order;
import com.example.supermarketcheckoutapp.domains.ProductRequest;
import com.example.supermarketcheckoutapp.services.ProductRequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/product_request")
public class ProductRequestController {

    private final ProductRequestServices productRequestServices;

    //posting the product requests
    @PostMapping("")
    public String saveProdRequest(@RequestBody ProductRequest productRequest){
        return productRequestServices.saveProductRequest(productRequest);
    }

    //getting the products requests
    @GetMapping("")
    public List<ProductRequest> getProductRequest(){
        return productRequestServices.getProductRequest();
    }
}
