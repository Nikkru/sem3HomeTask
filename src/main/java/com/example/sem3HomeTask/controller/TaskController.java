package com.example.sem3HomeTask.controller;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsers() {
        return service.sortUserByAge(service.getUserRepository().getUsers());
    }

    @GetMapping("/filter")
    public List<User> filterUsers(int age) {
        return service.filterUserByAge(service.getUserRepository().getUsers(), age);
    }

    @GetMapping("/calculate")
    public double calcUsers() {
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }

}
