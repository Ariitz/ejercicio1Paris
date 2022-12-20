package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ShipmentEntity {
    private String orderId;
    private String shipmentId;
    private String productId;
    private Date shipmentDate;
    private Double qty;
}
