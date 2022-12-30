package com.example.movie.dao;

import com.example.movie.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper extends BaseMapper<Order,Integer>{

    List<Order> findOrderByUserId(Integer uid);
}
