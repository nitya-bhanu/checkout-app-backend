package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Cart {
    @Id
    private String userId;
    private List<ProductAndQuantity> productAndQuantityList;
}
