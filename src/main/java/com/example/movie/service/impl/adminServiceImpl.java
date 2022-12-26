package com.example.movie.service.impl;

import com.example.movie.dao.adminMapper;
import com.example.movie.pojo.Admin;
import com.example.movie.service.adminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class adminServiceImpl implements adminService {
    @Resource
    private adminMapper adminMapper;

    @Override
    public List<Admin> findAll(){
        return adminMapper.findAll();
    }

    @Override
    public Admin login(String name, String pwd) {
        return adminMapper.selectByName(name,pwd);
    }
}
