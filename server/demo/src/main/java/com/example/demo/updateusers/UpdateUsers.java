package com.example.demo.updateusers;

import com.example.demo.database.data.User;

import java.util.List;

public interface UpdateUsers {

    void retrieveUsers();

    void updateDatabase(List<User> users);

}
