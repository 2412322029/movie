package com.example.movie.controller;

import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/findUserByPage")
    public Result<Map<String, Object>> findByPage(Integer pageNum, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageSize=" + pageSize + ",pageNum=" + pageNum);
        List<User> mList = userService.findUserByPage(pageNum, pageSize);
        Integer totals = userService.findTotals();
        Integer totalPage = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
        map.put("userList",mList);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        return Result.success("分页用户查询成功",map);
    }
}
