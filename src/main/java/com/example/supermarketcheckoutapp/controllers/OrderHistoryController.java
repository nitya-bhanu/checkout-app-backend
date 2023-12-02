package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.domains.ProductAndQuantity;
import com.example.supermarketcheckoutapp.services.OrderHistoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-history")
public class OrderHistoryController {
    private final OrderHistoryServices orderHistoryServices;

    @PostMapping("")
    public List<Product> getAllOrderedProducts(@RequestBody List<ProductAndQuantity> productAndQuantityList){
        return orderHistoryServices.getAllProductsList(productAndQuantityList);
    }

    @PostMapping("/get-orders-quantity-list")
    public List<ProductAndQuantity> getAllProductQuantityList(@RequestBody String userId){
        return orderHistoryServices.getAllOrderedProductsAndQuantityList(userId);
    }
}
