/*
 *@Project ：White-Jotter-Lv
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/2/27 8:18 下午
 */


package com.lv.utils;

import java.util.Random;

public class StringUtils {
    //生成制定长度随机字符串
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


}
