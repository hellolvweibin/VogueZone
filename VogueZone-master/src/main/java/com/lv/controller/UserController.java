package com.lv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lv.entity.User;
import com.lv.result.Result;
import com.lv.result.ResultFactory;
import com.lv.service.UserService;
import com.lv.utils.JwtUtils;
import com.lv.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        try {
            //查询用户是否存在
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username", user.getUsername());
            User users = userService.getOne(wrapper);
            if (users != null) {
                return ResultFactory.buildFailResult("对不起，用户已存在！");
            }
            //对密码加密
            String s = MD5Utils.md5(user.getPassword());

            //保存用户,头像是默认的
            user.setPassword(s);
            user.setAvatar("https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png");
            userService.save(user);
            return ResultFactory.buildSuccessResult(user);


        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("对不起,保存失败！");

        }

    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(user.getUsername() != null, "username", user.getUsername());
        User users = userService.getOne(wrapper);
        //校验密码
        String s = MD5Utils.md5(user.getPassword());
        if (!users.getPassword().equals(s)) {
            return ResultFactory.buildFailResult("对不起，密码不正确！");
        }

        wrapper.in(user.getPassword() != null, "password", s);
        //通过用户名从数据库中查询该用户
        if (users == null) {
            return ResultFactory.buildFailResult("对不起，用户不存在");
        }
        return ResultFactory.buildSuccessResult("登录成功！！");






    }

}
