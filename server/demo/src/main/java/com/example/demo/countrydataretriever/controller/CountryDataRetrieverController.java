package com.example.demo.countrydataretriever.controller;

import com.example.demo.countrydataretriever.CountryDataRetriever;
import com.example.demo.countrydataretriever.data.ProcessedData;
import com.example.demo.countrydataretriever.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryDataRetrieverController implements CountryDataRetriever {

    @Autowired
    Processor processor;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    // this call indicates that it is a get method
    public ResponseEntity<ProcessedData> getData() {
        return ResponseEntity.ok(processor.processDatabaseData());
    }
}
