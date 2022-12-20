package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEntity {
    OrderEntity order;
    ShipmentEntity shipment;
}
