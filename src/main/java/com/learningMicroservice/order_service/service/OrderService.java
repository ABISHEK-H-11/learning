package com.learningMicroservice.order_service.service;

import com.learningMicroservice.order_service.clint.ProductClint;
import com.learningMicroservice.order_service.dto.OrderRequest;
import com.learningMicroservice.order_service.dto.OrderResponse;
import com.learningMicroservice.order_service.dto.product.ProductApiResponse;
import com.learningMicroservice.order_service.entity.Order;
import com.learningMicroservice.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ProductClint productClint;

    public OrderService(OrderRepository orderRepository, ProductClint productClint) {
        this.orderRepository = orderRepository;
        this.productClint = productClint;
    }


    public OrderResponse createOrder(OrderRequest orderRequest) {
        ProductApiResponse productApiResponse = productClint.getProduct(orderRequest.getProductId());
        System.out.println(productApiResponse);
        if(productApiResponse == null || !productApiResponse.isSuccess()) {
            throw new RuntimeException("Product Not found");
        }
        if(productApiResponse.getData().getQuantity() < orderRequest.getQuantity()) {
            throw new RuntimeException("Out of Stock");
        }

        Order order = new Order(orderRequest.getProductId(),orderRequest.getProductId(),"Placed");
         order =orderRepository.save(order);
         return new OrderResponse(order.getId(),order.getProductId(),order.getQuantity(),order.getStatus(),"Order placed successfully");
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for(Order order : orders) {
            orderResponses.add(new OrderResponse(order.getId(),order.getProductId(),order.getQuantity(),order.getStatus(),"Order placed successfully"));
        }
        return orderResponses;
    }

    public  OrderResponse getByOrderId(Integer id){
        Order order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
        return new OrderResponse(order.getId(),order.getProductId(),order.getQuantity(),order.getStatus(),"Order placed successfully");
    }

    public String deleteTheOrder(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
        orderRepository.delete(order);
        return "Order deleted successfully";
    }
}
