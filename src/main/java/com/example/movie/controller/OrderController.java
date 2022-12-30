package com.example.movie.controller;

import com.example.movie.pojo.Order;
import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/addOrder")
    public Result<Order> addOrder(@RequestBody Order order) {
        return orderService.save(order);

    }

    @RequestMapping("/findOrderByUserId")
    public Result<List<Order>> findOrderByUserId(@RequestParam("uid") Integer uid) {
        return orderService.findOrderByUserId(uid);

    }
}
