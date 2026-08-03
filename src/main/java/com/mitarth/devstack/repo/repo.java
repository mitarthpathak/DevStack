package com.mitarth.devstack.repo;

import com.mitarth.devstack.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
