package com.example.spring_boot_testing_app.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ApiClient {

    private final RestClient scryfallRestClient;

    public ApiClient(RestClient scryfallRestClient) {
        this.scryfallRestClient = scryfallRestClient;
    }

    public JsonNode retrieve() {
        return scryfallRestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/cards/cma/176/rulings").build())
                .header("User-Agent", "spring-boot-testing-app")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(JsonNode.class);
    }
}
