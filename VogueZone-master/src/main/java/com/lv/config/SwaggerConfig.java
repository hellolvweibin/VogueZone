/*
 *@Project ：VogueZone
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/5/15 3:13 下午
 */


package com.lv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //配置Swagger的bean实例
    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("LV")
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage 制定要扫描的包
                //any 扫描全部
                //none 不扫描
                //withMethodAnnotation扫描类上面的注解

                .apis(RequestHandlerSelectors.basePackage("com.lv.controller")
                )

                .build();


    }

    //配置Swagger 信息ApiInfo

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("吕炜彬", "https://github.com/hellolvweibin", "279369954@qq.com");

        return new ApiInfo("LV 的SwaggerAPI文档", "Just Coding", "1.0", "urn:tos",
                contact, "Apache 2.0", "https://github.com/hellolvweibin", new ArrayList<>());

    }
}
