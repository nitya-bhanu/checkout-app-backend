package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.Cart;
import com.example.supermarketcheckoutapp.domains.ProductAndQuantity;
import com.example.supermarketcheckoutapp.repositories.CartRepository;
import com.example.supermarketcheckoutapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@RequiredArgsConstructor
public class CartServices {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private double sumTotal=0;
    public String saveCart(Cart cart){
        if(cartRepository.findById(cart.getUserId()).isPresent()){
            List<ProductAndQuantity> productAndQuantity=cartRepository.findById(cart.getUserId()).get().getProductAndQuantityList();

            productAndQuantity.addAll(cart.getProductAndQuantityList());
            cart.setProductAndQuantityList(productAndQuantity);
        }
        cartRepository.save(cart);
        return "Saved Successfully";
    }

    public Optional<Cart> updateCart(String userId, String productId, String argument){
        Optional<Cart> cart=cartRepository.findById(userId);
        if(cart.isPresent()){
            List<ProductAndQuantity> productAndQuantityList=cart.get().getProductAndQuantityList();
            productAndQuantityList.forEach(productAndQuantity -> {
                if(productAndQuantity.getProductId().equals(productId)){
                    int quantity=productAndQuantity.getOrderedProductQuantity();
                    if(argument.equals("add"))
                        quantity++;
                    else
                        quantity--;
                    productAndQuantity.setOrderedProductQuantity(quantity);
                }
            });
            cartRepository.save(cart.get());
        }
        return cart;
    }

    public List<Cart> deleteCart(String userId,String productId){
        if(cartRepository.findById(userId).isPresent()){
            Cart cart=cartRepository.findById(userId).get();
            List<ProductAndQuantity> productAndQuantityList=cart.getProductAndQuantityList();
            productAndQuantityList.removeIf(productAndQuantity -> productAndQuantity.getProductId().equals(productId));
            cartRepository.save(cart);
        }
        return cartRepository.findAll();
    }

    public void deleteWholeCart(String userId){
        cartRepository.deleteById(userId);
    }

    public Cart getCart(String userId) throws Exception{
      Optional <Cart> cart=cartRepository.findById(userId);
      if(cart.isEmpty())
          throw new Exception();
      else
          return cart.get();
    }

    public double getSumTotal(String userId){
        sumTotal=0;
        if(cartRepository.findById(userId).isPresent()){
            List<ProductAndQuantity> productAndQuantityList= cartRepository.findById(userId).get().getProductAndQuantityList();
            productAndQuantityList.forEach(productAndQuantity -> {
                Double priceValue = productRepository.findById(productAndQuantity.getProductId()).get().getPrice();
                Optional<Double> price = Optional.ofNullable(priceValue);
                double x = productAndQuantity.getOrderedProductQuantity();
                if (price.isPresent()) {
                    sumTotal += x * price.get();
                }
            });
        }
        System.out.println("sumtotal: "+sumTotal);
        return sumTotal;
    }

    public int getTotalCartLength(String userId){
        int cartLength=0;
        if(cartRepository.findById(userId).isPresent()){
            List<ProductAndQuantity> productAndQuantityList= cartRepository.findById(userId).get().getProductAndQuantityList();
           cartLength= productAndQuantityList.size();
           return cartLength;
        }
        else
            return 0;
    }
}
