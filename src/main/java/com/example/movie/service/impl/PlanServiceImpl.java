package com.example.movie.service.impl;

import com.example.movie.dao.HallMapper;
import com.example.movie.dao.MovieMapper;
import com.example.movie.dao.PlanMapper;
import com.example.movie.pojo.*;
import com.example.movie.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;
    @Resource
    private HallMapper hallMapper;
    @Resource
    private MovieMapper movieMapper;

    @Override
    public Result<Plan> addPlan(Plan plan) {
        if (Objects.nonNull(plan)) {
            if (planMapper.checkUsable(plan.getHall_id(), plan.getPlaytime()) == 0) {
                Hall hall = hallMapper.findOne(plan.getHall_id());
                if (Objects.nonNull(hall)) {
                    plan.setSeats(hall.getSeats());
                    int n = planMapper.save(plan);
                    if (n > 0) {
                        return Result.success("计划添加成功", plan);
                    } else {
                        return Result.fail("计划添加失败");
                    }
                }
            } else {
                return Result.fail("已经有排片，无法添加");
            }
        }
        return Result.fail("对象不能为空，计划添加失败");
    }

    @Override
    public Map<String,Object> findPlanByPlanId(Integer id) {
        Plan plan = planMapper.findOne(id);
        Movie movie=movieMapper.findOne(plan.getMovie_id());
        Hall hall = hallMapper.findOne(plan.getHall_id());
        HashMap<String,Object> map=new HashMap<>();
        map.put("plan",plan);
        map.put("movie",movie);
        map.put("hall",hall);
        return map;

    }

    @Override
    public Integer findTotals() {
        return planMapper.findTotals();
    }

    @Override
    public List<Plan> findPlanListByMovieId(Integer id) {
        return planMapper.findPlanListByMovieId(id);
    }

    @Override
    public Result<Plan> updateSeats(String seats, String pid) {
        int n = planMapper.updateSeats(seats,pid);
        if (n>0){
            return Result.success("更新座位成功",null);
        }else {
            return Result.fail("更新座位失败");
        }
    }


}
