package com.mitarth.devstack.repo;

import com.mitarth.devstack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
