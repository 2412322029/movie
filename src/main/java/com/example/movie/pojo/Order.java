package com.example.movie.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Integer id;
    private Integer status;
    private BigDecimal price;
    private Integer user_id;
    private Integer plan_id;
    private String seat;
}
