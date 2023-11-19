package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAndQuantity {
    private String productId;
    private Integer orderedProductQuantity;
}
