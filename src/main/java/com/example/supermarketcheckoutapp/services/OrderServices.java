package com.example.supermarketcheckoutapp.services;
import com.example.supermarketcheckoutapp.domains.Order;
import com.example.supermarketcheckoutapp.domains.Product;
import com.example.supermarketcheckoutapp.domains.ProductAndQuantity;
import com.example.supermarketcheckoutapp.domains.User;
import com.example.supermarketcheckoutapp.repositories.CartRepository;
import com.example.supermarketcheckoutapp.repositories.OrderRepository;
import com.example.supermarketcheckoutapp.repositories.ProductRepository;
import com.example.supermarketcheckoutapp.repositories.UserRepository;
import com.example.supermarketcheckoutapp.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServices {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    Order order=new Order();
    public Order saveOrderDetails(Order orderRequest,Double price){
        boolean check=false;
        String uid= orderRequest.getUserId();
        List<ProductAndQuantity> prods= orderRequest.getProductAndQuantityList();
        List<Product> products=productRepository.findAll();
        for(ProductAndQuantity loopProds:prods){
            for(Product product:products){
                if(product.getProdId().equals(loopProds.getProductId())){
                    if(product.getQuantity()>loopProds.getOrderedProductQuantity()) {
                        check=true;
                        product.setQuantity(product.getQuantity()-loopProds.getOrderedProductQuantity());
                    }
                    else
                    {
                        check=false;
                        break;
                    }
                }
            }
        }
        if(check){
            order.setOrderDate(java.time.LocalDate.now());
            order.setProductAndQuantityList(orderRequest.getProductAndQuantityList());
            order.setUserId(uid);
            order.setTotalMoney(price);
            orderRepository.save(order);
            cartRepository.deleteById(uid);
            productRepository.saveAll(products);
            User user=userRepository.findById(orderRequest.getUserId()).get();
            Double d=user.getLoyaltyBalance();
            d=d+(price/1000);
            user.setLoyaltyBalance(d);
            userRepository.save(user);
            System.out.println("Success");
        }
        else
            System.out.println("Unsuccessfuly");

        return orderRequest;
    }
    public List<Order> getOrderDetails(){
        return orderRepository.findAll();
    }
}
