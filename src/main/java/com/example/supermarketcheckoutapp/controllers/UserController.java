package com.example.supermarketcheckoutapp.controllers;

//import com.example.supermarketcheckoutapp.config.UserInfoUserDetails;
import com.example.supermarketcheckoutapp.domains.User;
import com.example.supermarketcheckoutapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserServices userServices;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) throws Exception {
        try{
            return userServices.getUserByID(userId);
        }
        catch(Exception e) {
            return userServices.getUserByID(userId);
        }
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userServices.getUser();
    }

    @PostMapping("")
    public String setUser(@RequestBody User user){
        return userServices.setUser(user);
    }

    @PostMapping("/setAsAdmin")
    public String setUserAsAdmin(@RequestBody String userId){
        return userServices.setUserAsAdmin(userId);
    }
}
