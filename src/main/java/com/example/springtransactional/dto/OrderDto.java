package com.example.springtransactional.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {

    private UUID id;

    private Long number;

    private LocalDate dateOrder;

    private BigDecimal value;

}
