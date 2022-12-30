package com.example.movie.controller;

import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/plan")
@CrossOrigin
@Slf4j
public class PlanController {
    @Resource
    private PlanService planService;

    @RequestMapping("/addPlan")
    public Result<Plan> addHall(@RequestBody Plan plan) {
        return planService.addPlan(plan);

    }

    @RequestMapping("/findPlanByPlanId")
    public Map<String, Object> findPlanById(@RequestParam("id") Integer pid) {
       return planService.findPlanByPlanId(pid);

    }

    @RequestMapping("/findPlanListByMovieId")
    public Result<List<Plan>> findPlanListByMovieId(@RequestParam("id") Integer id){
        return Result.success(id+"-查询成功",planService.findPlanListByMovieId(id));
    };

    @RequestMapping("/updateSeats")
    public Result<Plan> updateSeats(@RequestBody Map<String,String> map){
        String pid=map.get("pid");
        System.out.println(pid);
        String seats= map.get("seats");
        log.info(pid+seats);
        return planService.updateSeats(seats,pid);
    }

}

