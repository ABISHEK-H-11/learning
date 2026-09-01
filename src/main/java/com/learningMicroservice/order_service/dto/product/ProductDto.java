package com.learningMicroservice.order_service.dto.product;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
}
