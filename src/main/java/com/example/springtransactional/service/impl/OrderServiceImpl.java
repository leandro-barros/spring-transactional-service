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

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public OrderDto save(OrderDto orderDto) {
        var orderModel = new OrderModel();
        BeanUtils.copyProperties(orderDto, orderModel);
        orderRepository.save(orderModel);
        if (true) {
            throw new RuntimeException();
        }
        orderDto.setId(orderModel.getId());
        return orderDto;
    }

}
