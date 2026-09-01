package com.learningMicroservice.order_service.dto.product;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductApiResponse {
    private boolean success;
    private String message;
    private ProductDto data;
}
