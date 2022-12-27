package com.example.movie.dao;

import com.example.movie.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper extends BaseMapper<Movie,Integer>{
}
