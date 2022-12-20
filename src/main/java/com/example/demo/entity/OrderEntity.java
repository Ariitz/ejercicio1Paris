package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderEntity {
    private String orderId;
    private String productId;
    private Double qty;
}
