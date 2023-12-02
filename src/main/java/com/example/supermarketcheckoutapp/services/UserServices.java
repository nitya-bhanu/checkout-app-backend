package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.User;
import com.example.supermarketcheckoutapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepository;
    public void createUser(User user){
        userRepository.save(user);
    }
    public void updateUser(String userID,User user){
        userRepository.save(user);
    }
    public void deleteUser(String userID,User user){
        userRepository.deleteById(userID);
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public User getUserByID(String prodId) throws Exception{
        Optional<User> user=userRepository.findById(prodId);
        if(user.isEmpty()) {
            throw new Exception();
        }
        return user.get();
    }

    public String setUser(User user){
        String hashedPassword=encryptPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "User Saved succesfully";
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

    public String setUserAsAdmin(String userID){
       Optional<User> user=userRepository.findById(userID);
       if(user.isPresent()){
           user.get().setRole("admin");
           userRepository.save(user.get());
           return "User Set to Admin Successfully";
       }
       else
           return "User Not Found";
    }

}
