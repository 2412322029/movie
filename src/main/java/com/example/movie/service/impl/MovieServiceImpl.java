package com.example.movie.service.impl;

import com.example.movie.dao.MovieMapper;
import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieMapper movieMapper;

    @Override
    public Result<Movie> addMovie(Movie movie) {
        if (Objects.nonNull(movie)) {

            int n=movieMapper.save(movie);
            if (n > 0){
                return Result.success("影片添加成功",movie);
            }else {
                return Result.fail("影片添加失败");
            }
        }else {
            return Result.fail("影片信息为空");
        }
    }

    @Override
    public List<Movie> findByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize;
        int rows = pageSize;
        return movieMapper.findByPage(start, rows);
    }

    @Override
    public Integer findTotals() {
        return movieMapper.findTotals();

    }

    @Override
    public List<Movie> findAllMovie() {
        return movieMapper.findAll();
    }

    @Override
    public List<Hall> findUsableHall() {
        return movieMapper.findUsableHall();
    }

    @Override
    public Movie findOne(Integer mid) {
        return movieMapper.findOne(mid);
    }
}
