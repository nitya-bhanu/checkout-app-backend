package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Order;
import com.example.supermarketcheckoutapp.request.OrderRequest;
import com.example.supermarketcheckoutapp.services.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServices orderServices;

    //posting the sum total of order
    @PostMapping ("/{sumTotal}")
    public Order saveOrderDetails(@PathVariable Double sumTotal,@RequestBody Order orderRequest){
        return orderServices.saveOrderDetails(orderRequest,sumTotal);
    }

    //getting the order details
    @GetMapping("")
    public List<Order> getOrderDetails(){
        return orderServices.getOrderDetails();
    }
}
