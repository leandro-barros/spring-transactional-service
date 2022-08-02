package com.example.springtransactional.controller;

import com.example.springtransactional.dto.OrderDto;
import com.example.springtransactional.service.OrderService;
import com.example.springtransactional.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("v1/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveOrderTransactional(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().body(orderService.save(orderDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderModel> findById(@PathVariable UUID id) {
       return ResponseEntity.ok().body(orderService.findById(id));
    }

}
