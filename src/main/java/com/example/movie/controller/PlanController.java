package com.example.movie.controller;

import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/plan")
@CrossOrigin
@Slf4j
public class PlanController {
    @Resource
    private PlanService planService;

    @RequestMapping("/addPlan")
    public Result<Plan> addHall(@RequestBody Plan plan){
        return planService.addPlan(plan);

    }
}

