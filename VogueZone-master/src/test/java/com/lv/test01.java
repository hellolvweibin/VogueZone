/*
 *@Project ：VogueZone
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/3/30 7:49 下午
 */


package com.lv;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lv.entity.Demo;
import com.lv.entity.User;
import com.lv.mapper.DemoMapper;
import com.lv.service.DemoService;
import com.lv.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test01 {
    @Autowired
    DemoService demoService;

    @Autowired
    DemoMapper demoMapper;

    @Test
    public void test02(){

    }
}
