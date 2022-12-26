package com.example.movie.service;

import com.example.movie.pojo.Admin;

import java.util.List;

public interface adminService {
    List<Admin> findAll();

    Admin login(String name, String pwd);
}
