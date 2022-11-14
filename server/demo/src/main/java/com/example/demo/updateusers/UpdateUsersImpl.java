package com.example.demo.updateusers;

import com.example.demo.database.Database;
import com.example.demo.database.data.User;
import com.example.demo.updateusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateUsersImpl implements UpdateUsers {

    @Autowired
    UserService userService;

    @Autowired
    Database database;

    @Override
    @Scheduled(fixedRateString = "${period}" + "000")
    public void retrieveUsers() {
        updateDatabase(userService.retrieveUsers());
    }

    @Override
    public void updateDatabase(List<User> users) {
        database.update(users);
    }
}
