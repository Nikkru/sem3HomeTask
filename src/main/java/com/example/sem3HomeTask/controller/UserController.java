package com.example.sem3HomeTask.controller;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import com.example.sem3HomeTask.services.RegistrationService;
import com.example.sem3HomeTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    DataProcessingService service;
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/{name}, {age}, {email}")
    public void userAddFromParam(
            @PathVariable("name") String name,
            @PathVariable("age") int age,
            @PathVariable("email") String email) {
        registrationService.processRegistration(name, age, email);
    }

    @GetMapping
    public List<User> getAllTasks() {
        return service.getListUsers();
    }
}
