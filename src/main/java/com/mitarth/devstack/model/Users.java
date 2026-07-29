package com.mitarth.devstack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.jspecify.annotations.Nullable;
@Entity
public class Users {
    @Id
    private Integer id;
    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }

    public @Nullable Object getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
