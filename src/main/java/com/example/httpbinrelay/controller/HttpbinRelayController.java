package com.example.httpbinrelay.controller;

import com.example.httpbinrelay.model.RelayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class HttpbinRelayController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/relay")
    public Mono<String> relayPost(@RequestBody RelayRequest request) {
        return webClient.post()
                .uri("/post") // Append endpoint to the base URL
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class);
    }
}
