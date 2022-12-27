package com.example.movie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface BaseMapper<T,K> {
    //增删改查信息
    int save(T t);

    int update(T t);

    int delete(K k);

    T findOne(K k);

    List<T> findAll();

    List<T> findByPage(@Param("start") Integer start,
                       @Param("rows") Integer rows);

    Integer findTotals();

}
