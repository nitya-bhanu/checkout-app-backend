package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "products")
public class Product {
    @Id
    private String prodId;
    private Integer quantity;
    private Double price;
    private String title;
    private String category;
    private String rating;
    private String description;
    private String imageUrl;
}
