package com.example.spring_boot_testing_app.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiClientConfiguration {
    @Bean
    public RestClient scryfallRestClient() {
        return RestClient.builder().baseUrl("https://api.scryfall.com").build();
    }

    @Bean
    public WebClient gathererWebClient() {
        return WebClient.builder().baseUrl("https://api.scryfall.com").build();
    }

}
