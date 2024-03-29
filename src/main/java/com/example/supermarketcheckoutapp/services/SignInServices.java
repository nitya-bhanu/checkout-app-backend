package com.example.supermarketcheckoutapp.services;

//import com.example.supermarketcheckoutapp.config.UserInfoUserDetails;
import com.example.supermarketcheckoutapp.domains.User;
import com.example.supermarketcheckoutapp.repositories.UserRepository;
import com.example.supermarketcheckoutapp.request.SignInRequest;
import com.example.supermarketcheckoutapp.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class SignInServices{

    private final UserRepository userRepository;

    public SignInResponse getUser(SignInRequest signInRequest){
        User user=userRepository.findByfields(signInRequest.getUserId());
        SignInResponse signInResponse=new SignInResponse();

        if(user.getPassword().equals(encryptPassword(signInRequest.getPassword()))){
            System.out.println("Successful Auth");
            signInResponse.setBool(true);
            signInResponse.setUserId(user.getUserId());
            signInResponse.setRole(user.getRole());
        }
        else
        {
            System.out.println("Unsuccessful Auth");
            signInResponse.setBool(false);
            signInResponse.setUserId(null);
            signInResponse.setRole(null);
        }
        return signInResponse;
    }

    public String encryptPassword(String password){
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] hashedPassword=messageDigest.digest();
            StringBuilder stringBuilder=new StringBuilder();
            for(byte b:hashedPassword){
                stringBuilder.append(String.format("%02x",b));
            }
            return stringBuilder.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }
}
