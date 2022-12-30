package com.example.movie.service.impl;

import com.example.movie.dao.UserMapper;
import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<User> register(User user) {
        if (user.getUsername() == null | user.getPassword() == null | user.getUsersex() == null
                | user.getUsertel() == null | user.getTruename() == null) {
            return Result.fail("输入为空");
        } else {
            User u=userMapper.selectByName(user.getUsername());
            if (u.getId()!=null){
                return Result.fail("用户名已注册");
            }else {
                userMapper.adduser(user);
                if (user.getId() != null) {
                    return Result.success(user);
                } else {
                    return Result.fail("注册失败");
                }
            }

        }
    }

    @Override
    public Result<User> login(User user) {
        log.info(user + "");
        if (user == null) {
            return Result.fail("空内容，登录失败");
        } else {
            User u = userMapper.checkUser(user);
            if (u != null) {
                if(u.getUserstatus()==null){
                    u.setUserstatus(0);
                };
                if (u.getUserstatus()==1){
                    return Result.fail("账号被封禁，登录失败");
                }else {
                    return Result.success(u);
                }
            } else {
                return Result.fail("登录失败");
            }

        }

    }

    @Override
    public List<User> findUserByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize;
        int rows = pageSize;
        return userMapper.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return userMapper.findTotals();
    }

    @Override
    public Result<User> findOne(Integer uid) {
        User user= userMapper.findOne(uid);
        if (Objects.nonNull(user)){
            return Result.success("查询用户成功",user);
        }else {
            return Result.fail("uid不存在");
        }
    }
}
