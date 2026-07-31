package com.mitarth.devstack.service;

import com.mitarth.devstack.model.Task;
import com.mitarth.devstack.model.Users;
import com.mitarth.devstack.repo.TaskRepository;
import com.mitarth.devstack.repo.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private repo usersRepository;


    public List<Task> getAllTasks(){
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        return repository.findByUserUsername(username);
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
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Users user = usersRepository.findByUsername(username);

        task.setUser(user);


        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        task.setUser(user);

        return repository.save(task);
    }
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
    public Task saveTask(Task task){
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Users user = usersRepository.findByUsername(username);

        task.setUser(user);

        return repository.save(task);
    }
}
