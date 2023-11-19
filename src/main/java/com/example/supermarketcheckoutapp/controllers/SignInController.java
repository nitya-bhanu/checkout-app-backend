package com.example.supermarketcheckoutapp.controllers;

import com.example.supermarketcheckoutapp.request.SignInRequest;
import com.example.supermarketcheckoutapp.response.SignInResponse;
import com.example.supermarketcheckoutapp.services.SignInServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/sign-in")
public class SignInController {

    @Autowired
    SignInServices signInServices;

    @PostMapping(value = "")
    public SignInResponse getUser(@RequestBody SignInRequest signInRequest){
        System.out.println("Called");
        return signInServices.getUser(signInRequest);
    }
}
