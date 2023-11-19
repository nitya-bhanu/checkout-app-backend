package com.example.supermarketcheckoutapp.response;

import com.example.supermarketcheckoutapp.domains.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPackageResponse<T> extends ProductResponse{
    private String message;
    private T data;
}
