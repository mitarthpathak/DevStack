package com.mitarth.devstack.service;

import com.mitarth.devstack.dto.LoginRequest;
import com.mitarth.devstack.dto.RegisterRequest;
import com.mitarth.devstack.model.Users;
import com.mitarth.devstack.repo.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private repo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users register(RegisterRequest request) {
        Users users = new Users();
        users.setUsername(request.getUsername());
        users.setPassword(encoder.encode(request.getPassword()));
        return repo.save(users);
    }

    public String verify(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            if (authentication.isAuthenticated()) {
                return JWTService.generatedToken(request.getUsername());
            }
            return "failed";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getClass().getSimpleName() + " : " + e.getMessage();
        }
    }
}