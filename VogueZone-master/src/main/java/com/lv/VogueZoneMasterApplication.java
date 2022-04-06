package com.lv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author levi_bee
 */
@SpringBootApplication
//@MapperScan("com.lv.mapper")
public class VogueZoneMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VogueZoneMasterApplication.class, args);
    }

}
