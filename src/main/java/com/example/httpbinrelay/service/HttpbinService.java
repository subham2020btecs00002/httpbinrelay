package com.example.httpbinrelay.service;

import com.example.httpbinrelay.model.RelayRequest;
import com.example.httpbinrelay.model.RelayResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpbinService {

    private final WebClient webClient;

    @Value("${httpbin.url}")
    private String httpbinUrl;

    public HttpbinService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(httpbinUrl).build();
    }

    public Mono<RelayResponse> forwardToHttpbin(RelayRequest request) {
        return webClient.post()
                .uri("/post")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(RelayResponse.class);
    }
}
