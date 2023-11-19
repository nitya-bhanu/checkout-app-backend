package com.example.supermarketcheckoutapp.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String userId;
    private String password;
    private String role;
    private String name;
    private String emailId;
    private String phoneNumber;
    private Double loyaltyBalance;
}
