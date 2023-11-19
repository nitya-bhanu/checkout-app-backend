package com.example.supermarketcheckoutapp.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse {
    String userId;
    Boolean bool;
    String role;
}
