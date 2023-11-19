package com.example.supermarketcheckoutapp.request;

import com.example.supermarketcheckoutapp.domains.ProductAndQuantity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String userId;
    private List<ProductAndQuantity> productAndQuantityList;
}