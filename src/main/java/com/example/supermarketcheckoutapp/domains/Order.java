package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "orders")
public class Order {
    @Id
    private String orderID;
    private String userId;
    private LocalDate orderDate;
    private List<ProductAndQuantity> productAndQuantityList;
    private Double totalMoney;
}
