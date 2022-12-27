package com.example.movie.controller;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;
import com.example.movie.service.HallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hall")
@CrossOrigin
@Slf4j
public class HallController {

    @Resource
    private HallService hallService;

    @RequestMapping("/addHall")
    public Result<Hall> addHall(@RequestBody Hall hall){
        return hallService.addHall(hall);

    }

    @RequestMapping("/findHall")
    public Result<List<Hall>> findHall(){
        return hallService.findAll();

    }
}
