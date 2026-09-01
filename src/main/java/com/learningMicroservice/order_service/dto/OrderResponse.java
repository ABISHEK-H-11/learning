package com.learningMicroservice.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderResponse {

    private Integer id;
    private Integer productId;
    private Integer quantity;
    private String status;
    private String message;
    
}
