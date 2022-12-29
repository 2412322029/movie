package com.example.movie.dao;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper extends BaseMapper<Movie,Integer>{
    public List<Hall> findUsableHall();
}
