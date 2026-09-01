package com.learningMicroservice.order_service.clint;

import com.learningMicroservice.order_service.dto.product.ProductApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductClint {

    private WebClient webClient;
    private static final String PRODUCT_SERVICE = "http://localhost:8081";

    public ProductClint(WebClient webClient) {
        this.webClient = webClient;
    }

    public ProductApiResponse getProduct(Integer id) {

        return webClient.get() 
                .uri(PRODUCT_SERVICE + "/api/product/" + id)
                .retrieve()
                .bodyToMono(ProductApiResponse.class)
                .block();
    }

}
