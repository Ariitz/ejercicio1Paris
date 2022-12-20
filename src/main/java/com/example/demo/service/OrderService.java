package com.example.demo.service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShipmentEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Callable;

@Service
public class OrderService {

    OrderEntity order = new OrderEntity("Order1", "Prod1", 2.0);
    ShipmentEntity shipment = new ShipmentEntity("Order1", "Ship1", "Prod1", new Date(2021 -02 -19), 2.0);

    public Callable<OrderEntity> getOrderDetails(final String orderId) {
        return () -> {
            if (order.getOrderId().equals(orderId)) {
                return  order;
            }
            return null;
        };
    }

    public Callable<ShipmentEntity> getShipmentDetails(final String orderId) {
        return () -> {
            if (shipment.getOrderId().equals(orderId)) {
                return shipment;
            }
            return null;
        };
    }
}
