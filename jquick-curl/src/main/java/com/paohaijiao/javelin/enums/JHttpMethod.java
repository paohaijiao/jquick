package com.paohaijiao.javelin.enums;

import com.paohaijiao.javelin.exception.Assert;
import lombok.Getter;

@Getter
public enum JHttpMethod {
    GET("GET","GET"),
    POST("POST","POST"),
    PUT("PUT","PUT"),
    DELETE("DELETE","DELETE"),
    PATCH("PATCH","PATCH"),
    HEAD("HEAD","HEAD"),
    OPTIONS("OPTIONS","OPTIONS"),
    TRACE ("TRACE ","TRACE "),
    CONNECT("CONNECT","CONNECT");

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
    public static boolean requireNotHaveRequestBody(String code){
        if(JHttpMethod.GET.getCode().equals(code)){
            return true;
        } else if (JHttpMethod.HEAD.getCode().equals(code)) {
            return true;
        } else if (JHttpMethod.CONNECT.getCode().equals(code)) {
            return true;
        }  else if (JHttpMethod.TRACE .getCode().equals(code)) {
            return true;
        }else{
            return false;
        }

    }
}
