package com.example.movie.dao;

import com.example.movie.pojo.admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface adminMapper {
    /*
    * 抽象方法
    * */
    List<admin> findAll();
}
