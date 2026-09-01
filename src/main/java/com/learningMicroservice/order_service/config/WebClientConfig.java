package com.learningMicroservice.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean //Http clint WebClient is Spring's modern HTTP client (introduced in Spring WebFlux). It is used to call other REST APIs from your application.
    public WebClient webClient() {
       return WebClient.builder().build();
    }
}
