package com.example.movie.service.impl;

import com.example.movie.dao.HallMapper;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class HallServiceImpl implements HallService {

    @Resource
    private HallMapper hallMapper;

    @Override
    public Result<Hall> addHall(Hall hall) {
        if (Objects.nonNull(hall)) {
            int n = hallMapper.save(hall);
            if (n > 0) {
                return Result.success("添加成功", null);
            } else {
                return Result.fail("添加失败");
            }
        } else {
            return Result.fail("信息为空");
        }
    }

    @Override
    public Result<List<Hall>> findAll() {
        List<Hall> listHall = hallMapper.findAll();
        return Result.success("查询成功", listHall);
    }

    @Override
    public Result<Hall> delete(Hall hall) {
        if (Objects.nonNull(hall)) {
            int n = hallMapper.delete(hall);
            if (n > 0) {
                return Result.success("删除成功", null);
            } else {
                return Result.fail("删除失败");
            }
        } else {
            return Result.fail("空信息");
        }

    }

    @Override
    public List<Hall> findByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize;
        int rows = pageSize;
        return  hallMapper.findByPage(start, rows);

    }

    @Override
    public Integer findTotals() {
        return hallMapper.findTotals();
    }

    @Override
    public Result<Hall> update(Hall hall) {
        if (Objects.nonNull(hall)) {
            int n = hallMapper.update(hall);
            if (n > 0) {
                return Result.success("更新成功", null);
            } else {
                return Result.fail("更新失败");
            }
        } else {
            return Result.fail("空信息");
        }

    }
}
