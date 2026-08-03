package com.mitarth.devtask.repo;

import com.mitarth.devtask.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
