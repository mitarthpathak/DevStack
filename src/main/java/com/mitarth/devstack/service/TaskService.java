package com.mitarth.devstack.service;

import com.mitarth.devstack.model.Task;
import com.mitarth.devstack.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    public Task getTask(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("task not found"));
    }
    public Task createTask(Task task){
        return repository.save(task);
    }
    public Task updateTask(Long id, Task updatedTask){
        Task task = getTask(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());

        return repository.save(task);
    }
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
