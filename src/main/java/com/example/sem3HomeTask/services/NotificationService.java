package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: "+user.getName());
    }

    public void notifyUsers(List<User> users, User user) {
        System.out.println(user.getName()+" has been add in users list. "+users.size()+" instances are there now.");
    }
}
