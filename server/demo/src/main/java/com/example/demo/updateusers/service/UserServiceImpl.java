package com.example.demo.updateusers.service;

import com.example.demo.database.data.User;
import com.example.demo.updateusers.data.Name;
import com.example.demo.updateusers.data.Result;
import com.example.demo.updateusers.data.Results;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Value("${url}")
    private String url;

    @Value("${userSize}")
    private int userSize;

    @Override
    public List<User> retrieveUsers() {
        RestTemplate restTemplate = new RestTemplate();
        Results results;
        try {
            results = restTemplate.getForEntity(url + userSize, Results.class).getBody();
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to retrieve results, will not update.", e);
        }
        return Optional.ofNullable(results)
                .map(Results::getResults)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(this::resultToUser)
                .collect(Collectors.toList());
    }

    private User resultToUser(Result result) {
        String country = result.getLocation().getCountry();
        Name name = result.getName();
        String fullName = String.format("%s %s %s", name.getTitle(), name.getFirst(), name.getLast());
        return new User(country, fullName, result.getGender(), result.getEmail());
    }
}
