package com.example.movie.service.impl;

import com.example.movie.dao.HallMapper;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class HallServiceImpl implements HallService {

    @Resource
    private HallMapper hallMapper;

    @Override
    public Result<Hall> addHall(Hall hall) {
       if (Objects.nonNull(hall)){
           int n=hallMapper.save(hall);
           if (n > 0){
               return Result.success("添加成功",null);
           }else {
               return Result.fail("添加失败");
           }
       }else {
           return Result.fail("信息为空");
       }
    }
}
