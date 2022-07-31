package com.example.springtransactional.service.impl;

import com.example.springtransactional.dto.OrderDto;
import com.example.springtransactional.model.OrderModel;
import com.example.springtransactional.repository.OrderRepository;
import com.example.springtransactional.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto save(OrderDto orderDto) {
        var orderModel = new OrderModel();
        BeanUtils.copyProperties(orderDto, orderModel);
        orderRepository.save(orderModel);

        orderDto.setId(orderModel.getId());
        return orderDto;
    }

}
