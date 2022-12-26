package com.example.movie.service.impl;

import com.example.movie.dao.AdminMapper;
import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;
import com.example.movie.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public Result<Admin> login(String name, String pwd) {
        if (name == null | pwd == null) {
            return Result.fail("登录失败");
        }else {
            Admin loginAdmin=adminMapper.selectByName(name, pwd);
            if (loginAdmin!=null){
                return Result.success(loginAdmin);

            }else {
                return Result.fail("登录失败");
            }
        }

    }
}
