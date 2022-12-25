package com.example.movie.controller;

import com.example.movie.pojo.admin;
import com.example.movie.service.adminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<admin> findAdminList(){
        List<admin> admins = adminService.findAll();
        log.info("测试:"+admins);
        return admins;
    }

}
