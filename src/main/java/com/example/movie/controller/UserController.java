package com.example.movie.controller;

import com.example.movie.dao.UserMapper;
import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result<User> register(@RequestBody User user){
        log.info(""+user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user){
        log.info(user+"");
        return userService.login(user);
    }
    @RequestMapping("/findAllUser")
    public Result<List<User>> findAllUser(){
        return userService.findAllUser();
    }
}
