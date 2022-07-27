package com.example.springtransactional.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "order")
public class OrderModel {

    @Id
    private UUID id;

    private Long number;

    private LocalDate dataOrder;

    private BigDecimal value;

}
