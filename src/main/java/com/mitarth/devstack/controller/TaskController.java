package com.mitarth.devstack.controller;

import com.mitarth.devstack.model.Task;
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
    public List<Task> getALLTasks(){
        return service.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return service.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.saveTask(task);
    }
    @PostMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return "Task deleted";
    }
}

