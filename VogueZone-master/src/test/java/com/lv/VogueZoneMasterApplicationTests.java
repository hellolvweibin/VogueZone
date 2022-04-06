package com.lv;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.lv.mapper")
class VogueZoneMasterApplicationTests {

    @Test
    void contextLoads() {
    }

}
