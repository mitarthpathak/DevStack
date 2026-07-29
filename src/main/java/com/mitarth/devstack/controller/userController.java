package com.mitarth.devstack.controller;

import com.mitarth.devstack.model.Users;
import com.mitarth.devstack.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private userService userservice;

    @GetMapping("/welcome")
    public String welocme() {
        return "Welcome to DevStack";
    }
    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userservice.register(users);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return userservice.verify(users);
    }
}
