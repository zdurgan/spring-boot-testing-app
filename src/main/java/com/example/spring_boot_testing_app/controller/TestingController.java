package com.example.spring_boot_testing_app.controller;


import com.example.spring_boot_testing_app.rest.ApiClient;
import com.example.spring_boot_testing_app.rest.ReactiveApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestingController {

    private final ApiClient apiClient;

    public TestingController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @PostMapping(value = "/element",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Void> receiveDocuments(@RequestBody String document) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/apiclient",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getRuling() {
        return new ResponseEntity<>(apiClient.retrieve(), HttpStatus.OK);
    }

    @GetMapping(value = "/ok",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

