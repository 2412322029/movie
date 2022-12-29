package com.example.movie.service;

import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;

import java.util.List;
import java.util.Map;

public interface PlanService{
    Result<Plan> addPlan(Plan plan);

    Map<String,Object> findPlanByPlanId(Integer id);

    Integer findTotals();

    List<Plan> findPlanListByMovieId(Integer id);
}
