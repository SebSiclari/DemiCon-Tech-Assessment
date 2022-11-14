package com.example.demo.database;

import com.example.demo.database.data.User;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DatabaseImpl implements Database {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Connection connection;


    public DatabaseImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "1234");
            submitSQL("Create table users (ID int primary key, country varchar(50), name varchar(50), gender varchar(50), email varchar(50))");
        } catch (SQLException e) {
            throw new RuntimeException("Database could not be created.", e);
        }

    }

    public void update(List<User> users) {
        for (User user : users) {
            int id = count.incrementAndGet();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(String.format("Insert into users (ID, country, name, gender, email) values (%d, ?, ?, ?, ?)", id));
                preparedStatement.setString(1, user.getCountry());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getGender());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException("User could not be inserted into the database.", e);
            }
        }
    }

    public List<User> retrieve() {
        List<User> results = new ArrayList<>();
        try {
            ResultSet resultSet = submitSQLQuery("SELECT * FROM users");
            while (resultSet.next()) {
                String country = resultSet.getString("country");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                results.add(new User(country, name, gender, email));
            }
        } catch (SQLException e) {
            throw new RuntimeException("User data could not be retrieved from the database.", e);
        }
        return results;
    }

    private void submitSQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    private ResultSet submitSQLQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    @PreDestroy
    private void onShutdown() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Connection couldn't close.", e);
        }
    }
}
