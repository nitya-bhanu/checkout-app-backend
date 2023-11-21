package com.example.supermarketcheckoutapp.services;

import com.example.supermarketcheckoutapp.domains.User;
import com.example.supermarketcheckoutapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userRepository.save(user);
        return "User Saved succesfully";
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
