package com.example.supermarketcheckoutapp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
    private String userId;
    private String password;
}
