package com.example.demo.countrydataretriever.processor;

import com.example.demo.countrydataretriever.data.ProcessedData;
import com.example.demo.database.Database;
import com.example.demo.database.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessorImpl implements Processor {

    @Autowired
    Database database;

    @Override
    public ProcessedData processDatabaseData() {
        Map<String, List<User>> countriesToUsers = database.retrieve()
                .stream()
                .collect(Collectors.groupingBy(User::getCountry));

        List<ProcessedData.ProcessedCountryData> processedCountryData = countriesToUsers
                .entrySet()
                .stream()
                .map(this::getProcessedCountryData)
                .collect(Collectors.toList());

        return new ProcessedData(processedCountryData);
    }

    private ProcessedData.ProcessedCountryData getProcessedCountryData(Map.Entry<String, List<User>> entry) {
        return new ProcessedData.ProcessedCountryData(entry.getKey(), entry.getValue()
                .stream()
                .map(this::getProcessedUserData)
                .collect(Collectors.toList()));
    }

    private ProcessedData.ProcessedUserData getProcessedUserData(User user) {
        return new ProcessedData.ProcessedUserData(user.getName(), user.getGender(), user.getEmail());
    }
}
