package com.mitarth.devstack.controller;

import com.mitarth.devstack.dto.LoginRequest;
import com.mitarth.devstack.dto.RegisterRequest;
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
    public Users register(@RequestBody RegisterRequest request) {
        return userservice.register(request);
    }

    //if user ever reach this endpoint he/she will get their own JWT token by which they logged in
    //sounds cool right??
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userservice.verify(request);
    }
}
