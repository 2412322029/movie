package com.example.movie.service.impl;

import com.example.movie.dao.OrderMapper;
import com.example.movie.pojo.Order;
import com.example.movie.pojo.Result;
import com.example.movie.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public Result<List<Order>> findOrderByUserId(Integer uid) {
        List<Order> orderList=orderMapper.findOrderByUserId(uid);
        if (orderList.size()!=0){
            return Result.success("订单查询成功",orderList);
        }else {
            return Result.fail("订单不存在");
        }
    }

    @Override
    public Result<Order> save(Order order) {
       int n= orderMapper.save(order);

       if (n>0){
           return Result.success("订单创建成功",order);
       }else {
           return Result.fail("订单创建失败");
       }
    }
}
