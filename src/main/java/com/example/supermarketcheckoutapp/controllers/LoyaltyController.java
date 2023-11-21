package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Loyalty;
import com.example.supermarketcheckoutapp.services.LoyaltyServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/loyalty")
public class LoyaltyController {

    private final LoyaltyServices loyaltyServices;

    //posting the loyalty details as set by admin
    @PostMapping(value = "")
    public void setLoyalty(@RequestBody Loyalty loyalty){
        loyaltyServices.postLoyaltySlab(loyalty);
    }

    //getting all the loyalty points discounts
    @GetMapping(value = "")
    public List<Loyalty> getLoyalty(){
        return loyaltyServices.getLoyaltySlab();
    }

    //getting the discount value against loyalty points
    @GetMapping(value = "/{loyaltyPoints}")
    public int getLoyaltyDiscountValue(@PathVariable int loyaltyPoints){
        return loyaltyServices.getLoyaltyDiscountValue(loyaltyPoints);
    }
}
