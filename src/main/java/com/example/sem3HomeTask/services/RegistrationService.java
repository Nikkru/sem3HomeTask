package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    public UserService userService;
    @Autowired
    public DataProcessingService dataProcessingService;
    @Autowired
    public UserRepository userRepository;

    public void processRegistration (String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
    }
}
