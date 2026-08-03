package com.mitarth.devstack.controller;

import com.mitarth.devstack.dto.TaskRequest;
import com.mitarth.devstack.dto.TaskResponse;
import com.mitarth.devstack.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<TaskResponse> getALLTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {
        return service.getTask(id);
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest task) {
        return service.saveTask(task);
    }

    @PostMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskRequest task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "Task deleted";
    }
}
