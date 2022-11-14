package com.example.demo.database.data;

import lombok.Data;

@Data
public class User {
    private final String country;
    private final String name;
    private final String gender;
    private final String email;
}
