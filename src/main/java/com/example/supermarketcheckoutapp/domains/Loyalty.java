package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document (collection = "loyalty")
public class Loyalty {
    @Id
    private String loyaltyId;
    private Integer levelValue;
    private Integer cashInValue;
}
