package com.example.movie.controller;

import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @RequestMapping("/findAll")
    public Result<List<Movie>> findAll(){
        return movieService.findAll();

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
}
