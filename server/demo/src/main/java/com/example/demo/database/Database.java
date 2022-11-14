package com.example.demo.database;

import com.example.demo.database.data.User;

import java.util.List;

public interface Database {

    void update(List<User> user);

    List<User> retrieve();

}
