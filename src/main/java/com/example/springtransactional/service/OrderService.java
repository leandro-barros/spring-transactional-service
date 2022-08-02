package com.example.springtransactional.service;

import com.example.springtransactional.dto.OrderDto;
import com.example.springtransactional.model.OrderModel;

import java.util.UUID;

public interface OrderService {

    public OrderDto saveOrderTransactional(OrderDto orderDto);

    OrderModel findById(UUID id);

    void updateOrderTrasactionWithRollback(UUID id, OrderDto orderDto);

}
