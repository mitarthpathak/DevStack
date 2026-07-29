package com.mitarth.devstack.service;

import com.mitarth.devstack.model.UserPrincipal;
import com.mitarth.devstack.model.Users;
import com.mitarth.devstack.repo.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailsService implements UserDetailsService {
    @Autowired
    private repo repo1;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users users = repo1.findByUsername(username);

        System.out.println("username from DB:" + users.getUsername());

        if (users == null){
            throw new UsernameNotFoundException("user not found");
        }

        System.out.println("password from DB: " + users.getPassword());

        return new UserPrincipal(users);
    }
}
