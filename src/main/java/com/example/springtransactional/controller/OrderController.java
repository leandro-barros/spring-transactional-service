package com.example.springtransactional.controller;

import com.example.springtransactional.dto.OrderDto;
import com.example.springtransactional.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private OrderService orderService;

    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().body(orderService.save(orderDto));
    }

}
