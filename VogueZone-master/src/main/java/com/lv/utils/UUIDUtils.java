/*
 *@Project ：VogueZone
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/4/23 10:41 上午
 */


package com.lv.utils;

import java.util.UUID;

//UUID生成工具
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}

