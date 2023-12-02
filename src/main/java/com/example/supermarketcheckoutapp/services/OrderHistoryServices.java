package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.domains.ProductAndQuantity;
import com.example.supermarketcheckoutapp.repositories.OrderRepository;
import com.example.supermarketcheckoutapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderHistoryServices {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<Product> getAllProductsList(List<ProductAndQuantity> productAndQuantityList){
        List<Product> productList = new ArrayList<>() {
        };
        productAndQuantityList.forEach(productAndQuantity -> {
            String prodId=productAndQuantity.getProductId();
           Optional<Product> pro=productRepository.findById(prodId);
            pro.ifPresent(productList::add);
        });
        return productList;
    }

    public List<ProductAndQuantity> getAllOrderedProductsAndQuantityList(String userId){
        List<ProductAndQuantity> productAndQuantityList=new ArrayList<>();
        orderRepository.findAll().forEach(order -> {

            if(order.getUserId().equals(userId)){
                productAndQuantityList.addAll(order.getProductAndQuantityList());
            }
        });
        return productAndQuantityList;
    }

}
