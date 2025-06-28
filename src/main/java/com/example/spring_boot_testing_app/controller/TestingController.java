package com.example.spring_boot_testing_app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestingController {

    public TestingController() {
    }

    @PostMapping(value = "/element",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Void> receiveDocuments(@RequestBody String document) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
