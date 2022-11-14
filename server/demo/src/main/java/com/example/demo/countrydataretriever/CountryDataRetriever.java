package com.example.demo.countrydataretriever;

import com.example.demo.countrydataretriever.data.ProcessedData;
import org.springframework.http.ResponseEntity;

public interface CountryDataRetriever {
    ResponseEntity<ProcessedData> getData();
}
