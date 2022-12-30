package com.example.movie.service;

import com.example.movie.pojo.Order;
import com.example.movie.pojo.Result;

import java.util.List;

public interface OrderService {
    Result<List<Order>> findOrderByUserId(Integer uid);

    Result<Order> save(Order order);
}
