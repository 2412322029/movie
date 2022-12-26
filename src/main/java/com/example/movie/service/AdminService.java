package com.example.movie.service;

import com.example.movie.pojo.Admin;
import com.example.movie.pojo.Result;

import java.util.List;

public interface AdminService {
    List<Admin> findAll();

    Result<Admin> login(String name, String pwd);
}
