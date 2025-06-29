package com.example.spring_boot_testing_app.rest;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ReactiveApiClient {
    private final WebClient gathererWebClient;

    public ReactiveApiClient(WebClient gathererWebClient) {
        this.gathererWebClient = gathererWebClient;
    }

    // TODO: Look into pagination with webflux
    public Flux<JsonNode> retrieve() {
        return gathererWebClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/cards/cma/176/rulings").build())
                .header("User-Agent", "spring-boot-testing-app")
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .doOnError(throwable -> {
                    log.info("Error happened {}", throwable.getMessage());
                });
        //"https://api.magicthegathering.io/v1/cards?name=\"Archangel Avacyn\""
    }

}
