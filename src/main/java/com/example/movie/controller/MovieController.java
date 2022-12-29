package com.example.movie.controller;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Plan;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/movie")
@CrossOrigin
@Slf4j
public class MovieController {
    @Resource
    private MovieService movieService;

    @PostMapping("/addMovie")
    public Result<Movie> addMovie(@RequestParam("file") MultipartFile file, Movie movie) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID()+ "."+extension;
        File saveDir = new File("D:\\24123\\code\\java\\movie\\src\\main\\resources\\static\\upload");
        if (!saveDir.exists()){
            saveDir.mkdirs();
        }
        File uploadFile = new File(saveDir,newFileName);
        file.transferTo(uploadFile);
        movie.setImg("upload/"+newFileName);
        log.info("文件地址："+movie.getImg());
        return movieService.addMovie(movie);
    }
    @RequestMapping("/findAllMovie")
    public Result<List<Movie>> findAllMovie(){
        return Result.success("电影信息查询成功",movieService.findAllMovie());

    }
    @RequestMapping("/findUsableHall")
    public Result<List<Hall>> findUsableHall(){
        return Result.success("可用信息查询成功",movieService.findUsableHall());
    }

    @PostMapping("/upload")
    public Result<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID()+ "."+extension;
        File saveDir = new File("D:\\24123\\code\\java\\movie\\src\\main\\resources\\static\\upload");
        if (!saveDir.exists()){
            saveDir.mkdirs();
        }
        File uploadFile = new File(saveDir,newFileName);
        file.transferTo(uploadFile);
        HashMap<String, String> map = new HashMap<>();
        map.put("path","upload/"+newFileName);
        return Result.success("ok",map);
    }

    @GetMapping("/findByPage")
    public Result<Map<String, Object>> findByPage(Integer pageNum, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        log.info("pageSize=" + pageSize + ",pageNum=" + pageNum);
        List<Movie> mList = movieService.findByPage(pageNum, pageSize);
        Integer totals = movieService.findTotals();
        Integer totalPage = totals % pageSize == 0 ? totals / pageSize : totals / pageSize + 1;
        map.put("movieList",mList);
        map.put("totals",totals);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        return Result.success("分页影片查询成功",map);
    }

    @RequestMapping("/findMovieByPid")
    public Result<Movie> findPlanById(@RequestParam("id") Integer mid) {
        Movie movie = movieService.findOne(mid);
        if (Objects.nonNull(movie)) {
            return Result.success("通过mid查询成功", movie);
        } else {
            return Result.fail("请求mid不存在");
        }
    }
}
