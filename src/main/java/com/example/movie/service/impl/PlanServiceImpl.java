package com.example.movie.service.impl;

import com.example.movie.dao.PlanMapper;
import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;

    @Override
    public Result<Plan> addPlan(Plan plan) {
        if (Objects.nonNull(plan)) {
            int n=planMapper.save(plan);
            if (n > 0){
                return Result.success("计划添加成功",plan);
            }else {
                return Result.fail("计划添加失败");
            }
        }else {
            return Result.fail("计划信息为空");
        }
    }
}
