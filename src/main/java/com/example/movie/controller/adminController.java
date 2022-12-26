package com.example.movie.controller;

import com.example.movie.pojo.Admin;
import com.example.movie.service.adminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@Slf4j
public class adminController {
    @Resource
    private adminService adminService;

    @GetMapping("/adminList")
    public List<Admin> findAdminList(){
        List<Admin> admins = adminService.findAll();
        log.info("测试:"+admins);
        return admins;
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin ad){
        return adminService.login(ad.getName(),ad.getPwd());

    }

}
