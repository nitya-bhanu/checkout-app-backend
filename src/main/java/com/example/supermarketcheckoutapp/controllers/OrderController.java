package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Order;
import com.example.supermarketcheckoutapp.request.OrderRequest;
import com.example.supermarketcheckoutapp.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    @PostMapping ("/{sumTotal}")
    public Order saveOrderDetails(@PathVariable Double sumTotal,@RequestBody Order orderRequest){
        return orderServices.saveOrderDetails(orderRequest,sumTotal);
    }
    @GetMapping("")
    public List<Order> getOrderDetails(){
        return orderServices.getOrderDetails();
    }
}
