package com.example.springtransactional.service.impl;

import com.example.springtransactional.dto.OrderDto;
import com.example.springtransactional.model.OrderModel;
import com.example.springtransactional.repository.OrderRepository;
import com.example.springtransactional.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public OrderDto saveOrderTransactional(OrderDto orderDto) {
        var orderModel = new OrderModel();
        BeanUtils.copyProperties(orderDto, orderModel);
        orderRepository.save(orderModel);
        if (true) {
            throw new RuntimeException();
        }
        orderDto.setId(orderModel.getId());
        return orderDto;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderModel findById(UUID id) {
        OrderModel orderModel = orderRepository.findById(id).orElse(null);
        return orderModel;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public void updateOrderTrasactionWithRollback(UUID id, OrderDto orderDto) throws Exception {
        OrderModel orderModel = orderRepository.findById(id).get();
        orderModel.setValue(orderDto.getValue());
        orderModel.setDateOrder(orderDto.getDateOrder());
        orderRepository.save(orderModel);
        if (true) {
            throw new Exception();
        }
    }

    @Override
    public void updateValueOrderTrasactionPreventRollback(UUID id, BigDecimal value) throws Exception {

    }
}
