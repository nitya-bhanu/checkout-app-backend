package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.domains.Cart;
import com.example.supermarketcheckoutapp.services.CartServices;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {


    private final CartServices cartServices;

    //posting the cart data
    @PostMapping("")
    public String saveCart(@RequestBody Cart cart){
        System.out.println("Here received");
        System.out.println(cart);
        return cartServices.saveCart(cart);
    }

    //updating the cart details
    @PutMapping(value = "",params = {"userId", "productId","argument"})
    public Optional<Cart> updateCart(@RequestParam(required = true) String userId, @RequestParam(required = true) String productId, @RequestParam (required = false) String argument){
        return cartServices.updateCart(userId,productId,argument);
    }

    //deleting the cart data
    @DeleteMapping(value = "",params={"userId", "productId","argument"})
    public List<Cart> deleteCart(@RequestParam(required = true) String userId, @RequestParam(required = true) String productId){
        return cartServices.deleteCart(userId,productId);
    }

    //deleting the cart
    @DeleteMapping(value = "/{userId}")
    public void deleteWholeCart(@PathVariable String userId){
       cartServices.deleteWholeCart(userId);
    }

    //getting the cart by userID
    @GetMapping(params = {"userId"})
    public Cart getCart(@RequestParam String userId){
        Cart cart=new Cart();
        try{
            cart=cartServices.getCart(userId);
            return cart;
        }
        catch(Exception e){
            System.out.println("User ID Fetched: "+userId);
            System.out.println("Error Fetching");
            return cart;
        }
    }

    //getting the sum total of cart products by userID
    @GetMapping(value = "/cartTotal/{userId}")
    public double getTotalPrice(@PathVariable String userId){
        return cartServices.getSumTotal(userId);
    }

    //getting the cart length by userId
    @GetMapping(value="/cartLength/{userId}")
    public int getCartLength(@PathVariable String userId){
        return cartServices.getTotalCartLength(userId);
    }
}
