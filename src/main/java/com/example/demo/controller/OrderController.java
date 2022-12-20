package com.example.demo.controller;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.RequestEntity;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/getOrderDetails")
    public ResponseEntity getOrderDetails(@RequestBody RequestEntity requestEntity) throws InterruptedException, ExecutionException {
        Callable<OrderEntity> order = orderService.getOrderDetails(requestEntity.getOrderId());
        Callable<ShipmentEntity> shipment = orderService.getShipmentDetails(requestEntity.getOrderId());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<OrderEntity> orderEntityFuture = executorService.submit(order);
        Future<ShipmentEntity> shipmentEntityFuture = executorService.submit(shipment);

        executorService.awaitTermination(2, TimeUnit.SECONDS);

        return new ResponseEntity(orderEntityFuture.get(), shipmentEntityFuture.get());
    }
}
