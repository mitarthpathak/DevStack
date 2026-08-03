package com.mitarth.devstack.dto;
//these DTO files are cerated to decide and filter what is shared to the user and like to hide the other stuff like username and userpass and JWT token
public class LoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
