package com.example.movie.dao;

import com.example.movie.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface adminMapper {
    /*
    * 抽象方法
    * */
    List<Admin> findAll();

    Admin selectByName(String name, String pwd);
}
