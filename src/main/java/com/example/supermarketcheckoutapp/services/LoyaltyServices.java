package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.Loyalty;
import com.example.supermarketcheckoutapp.repositories.LoyaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoyaltyServices {
    private final LoyaltyRepository loyaltyRepository;

    public void postLoyaltySlab(Loyalty loyalty){
        loyaltyRepository.save(loyalty);
    }

    public List<Loyalty> getLoyaltySlab(){
        return loyaltyRepository.findAll();
    }

    public int  getLoyaltyDiscountValue(int loyaltyPoints){
        List<Loyalty> list=loyaltyRepository.findAll();
        int discount=0;
        for(Loyalty loyalty1:list){
            if(loyalty1.getLevelValue()>loyaltyPoints) {
                discount = loyalty1.getCashInValue();
                return discount;
            }
            else{
                discount = loyalty1.getCashInValue();
            }
        }
        return discount;
    }

}
