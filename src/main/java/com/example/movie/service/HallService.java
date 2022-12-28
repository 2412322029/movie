package com.example.movie.service;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;

import java.util.List;

public interface HallService {
    Result<Hall> addHall(Hall hall);

    Result<List<Hall>> findAll();

    Result<Hall> delete(Hall hall);

    /**分页
     * @param pageNum 当前页
     * @param pageSize 页条数
     */
    List<Hall> findByPage(Integer pageNum,Integer pageSize);

    Integer findTotals();
    //总数查询

    Result<Hall> update(Hall hall);
}
