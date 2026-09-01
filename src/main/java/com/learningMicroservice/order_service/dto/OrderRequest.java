package com.learningMicroservice.order_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
    @NotNull(message = "product Id is required")
    private Integer productId;
    @Min(value = 1,message = "quantity should be at least 1")
    private Integer quantity;
}
