/*
 *@Project ：White-Jotter-Lv
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/2/28 12:34 下午
 */


package com.lv.result;

/**
 * @author levi_bee
 */


public enum ResultCode {

    //枚举返回代码
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
