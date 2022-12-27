package com.example.movie.dao;

import com.example.movie.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper extends BaseMapper<Admin,Integer>{
    /*
    * 抽象方法
    * */

    Admin selectByName(String name, String pwd);
}
