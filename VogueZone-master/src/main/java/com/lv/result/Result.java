/*
 *@Project ：White-Jotter-Lv
 *@IDE     ：IntelliJ IDEA
 *@Author  ：Levi_Bee
 *@Date    ：2022/2/24 3:04 下午
 */


package com.lv.result;

//Result 类是为了构造 response，主要是响应码


import lombok.Data;


/**
 * @author levi_bee
 */
@Data

public class Result {
    private int code;
    private String message;
    private Object result;
    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
