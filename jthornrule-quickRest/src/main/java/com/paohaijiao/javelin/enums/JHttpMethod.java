package com.paohaijiao.javelin.enums;

import com.paohaijiao.javelin.exception.Assert;

public enum JHttpMethod {
    GET("GET","GET"),
    POST("POST","POST"),
    PUT("PUT","PUT"),
    DELETE("DELETE","DELETE"),
    PATCH("PATCH","PATCH"),
    HEAD("HEAD","HEAD"),
    OPTIONS("OPTIONS","OPTIONS");

    private String code;
    private String name;

    JHttpMethod(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static JHttpMethod codeOf(String code){
        for(JHttpMethod httpMethod : JHttpMethod.values()){
            if(httpMethod.code.equals(code)){
                return httpMethod;
            }
        }
        Assert.throwNewException("非法的方法");
        return null;
    }
}
