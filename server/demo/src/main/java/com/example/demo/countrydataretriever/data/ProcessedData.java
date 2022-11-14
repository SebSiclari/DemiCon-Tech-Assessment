package com.example.demo.countrydataretriever.data;

import lombok.Data;

import java.util.List;

@Data // comes from the lombok dependency
public class ProcessedData {

    private final List<ProcessedCountryData> countries;

    @Data
    public static class ProcessedCountryData {

        private final String name;
        private final List<ProcessedUserData> users;

    }

    @Data // creates get and set methods for you, also creates constructors
    public static class ProcessedUserData {

        private final String name;
        private final String gender;
        private final String email;

    }
}
