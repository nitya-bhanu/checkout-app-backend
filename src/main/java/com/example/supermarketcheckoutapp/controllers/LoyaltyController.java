package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Loyalty;
import com.example.supermarketcheckoutapp.services.LoyaltyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {
    @Autowired
    LoyaltyServices loyaltyServices;

    @PostMapping(value = "")
    public void setLoyalty(@RequestBody Loyalty loyalty){
        loyaltyServices.postLoyaltySlab(loyalty);
    }

    @GetMapping(value = "")
    public List<Loyalty> getLoyalty(){
        return loyaltyServices.getLoyaltySlab();
    }

    @GetMapping(value = "/{loyaltyPoints}")
    public int getLoyaltyDiscountValue(@PathVariable int loyaltyPoints){
        return loyaltyServices.getLoyaltyDiscountValue(loyaltyPoints);
    }
}
