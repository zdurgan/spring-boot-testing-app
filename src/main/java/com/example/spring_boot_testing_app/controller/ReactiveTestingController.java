package com.example.spring_boot_testing_app.controller;

import com.example.spring_boot_testing_app.rest.ReactiveApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;


@Controller
@RequestMapping("/test")
public class ReactiveTestingController {
    private final ReactiveApiClient reactiveApiClient;

    public ReactiveTestingController(ReactiveApiClient reactiveApiClient) {
        this.reactiveApiClient = reactiveApiClient;
    }

    @GetMapping(value = "/reactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<JsonNode> getCard() {
        return reactiveApiClient.retrieve();
    }
}
