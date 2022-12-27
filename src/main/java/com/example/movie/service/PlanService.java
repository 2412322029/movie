package com.example.movie.service;

import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;

public interface PlanService{
    Result<Plan> addPlan(Plan plan);
}
