/*
 *@Project ：VogueZone
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/3/27 6:53 下午
 */


package com.lv.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lv.entity.Demo;

import com.lv.entity.User;
import com.lv.result.Result;
import com.lv.result.ResultFactory;
import com.lv.service.DemoService;
import com.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author levi_bee
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/api/login")
    public Result login(User requestUser) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(requestUser.getUsername() != null, "username", requestUser.getUsername());

        User user = userService.getOne(wrapper);
        if (user == null) {
            return ResultFactory.buildFailResult("用户不存在");
        } else {
            return ResultFactory.buildSuccessResult(user);
        }

    }

}
