package com.example.movie.controller;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;
import com.example.movie.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@Slf4j
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/adminList")
    public List<Admin> findAdminList(){
        List<Admin> admins = adminService.findAll();
        log.info("测试:"+admins);
        return admins;
    }

    @PostMapping("/login")
    public Result<Admin> login(@RequestBody Admin ad){
        return adminService.login(ad.getName(),ad.getPwd());

    }

}
