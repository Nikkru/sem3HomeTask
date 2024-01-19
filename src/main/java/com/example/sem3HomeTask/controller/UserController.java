package com.example.sem3HomeTask.controller;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import com.example.sem3HomeTask.services.NotificationService;
import com.example.sem3HomeTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    DataProcessingService service;

    @GetMapping("/{name}, {age}, {email}")
    public void userAddFromParam(
            @PathVariable("name") String name,
            @PathVariable("age") int age,
            @PathVariable("email") String email) {
        User user = userService.createUser(name, age, email);
        notificationService.notifyUser(user);
        service.addUserToList(user);
    }
}
