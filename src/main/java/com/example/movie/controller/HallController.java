package com.example.movie.controller;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hall")
@CrossOrigin
@Slf4j
public class HallController {

    @Resource
    private HallService hallService;

    @RequestMapping("/addHall")
    public Result<Hall> addHall(@RequestBody Hall hall) {
        return hallService.addHall(hall);

    }

    @RequestMapping("/findHall")
    public Result<List<Hall>> findHall() {
        return hallService.findAll();
    }

    @GetMapping("/findByPage")
    public Result<Map<String, Object>> findByPage(Integer pageNum, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageSize=" + pageSize + ",pageNum=" + pageNum);
        List<Hall> hallList = hallService.findByPage(pageNum, pageSize);
        Integer totals = hallService.findTotals();
        Integer totalPage = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
        map.put("hallList",hallList);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        return Result.success("查询成功",map);
    }

    ;

    @RequestMapping("/delete")
    public Result<Hall> delete(@RequestBody Hall hall) {
        return hallService.delete(hall);

    }

    @RequestMapping("/update")
    public Result<Hall> update(@RequestBody Hall hall) {
        return hallService.update(hall);

    }
}
