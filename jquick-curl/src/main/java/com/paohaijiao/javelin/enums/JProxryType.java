package com.paohaijiao.javelin.enums;

import com.paohaijiao.javelin.exception.JAssert;
import lombok.Getter;

@Getter
public enum JProxryType {
    HTTP("HTTP","HTTP"),
    SOCKET("SOCKET","SOCKET");

    private String code;
    private String name;

    JProxryType(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static JProxryType codeOf(String code){
        for(JProxryType httpMethod : JProxryType.values()){
            if(httpMethod.code.equals(code)){
                return httpMethod;
            }
        }
        JAssert.throwNewException("非法的方法");
        return null;
    }
}
