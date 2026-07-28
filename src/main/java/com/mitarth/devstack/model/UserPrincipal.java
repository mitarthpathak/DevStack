package com.mitarth.devstack.model;

import jakarta.annotation.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    private Users users;

    public UserPrincipal(Users users){
        this.users = users;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public @Nullable String getPassword(){
        return users.getPassword();
    }

    @Override
    public @Nullable String getUsername(){
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
}
