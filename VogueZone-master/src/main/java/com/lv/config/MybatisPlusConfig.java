/*
 *@Project ：VogueZone
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/3/27 3:58 下午
 */


package com.lv.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.lv.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义MP的拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //2.添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }


}


