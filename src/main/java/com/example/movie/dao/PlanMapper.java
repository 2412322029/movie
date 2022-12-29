package com.example.movie.dao;

import com.example.movie.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PlanMapper extends BaseMapper<Plan,Integer>{
    Integer checkUsable(@Param("hid") Integer hall_id,
                        @Param("t") Date playtime);

    Plan findById(Integer pid);

    List<Plan> findPlanListByMovieId(@Param("mid") Integer mid);
}
