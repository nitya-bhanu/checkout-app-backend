package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String title;
    private Integer quantity;
    private String description;
    private String category;
}