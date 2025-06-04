package com.paohaijiao.javelin.mapper;

import com.paohaijiao.javelin.obj.JSONObject;

import java.util.Map;

public interface BeanMapper {

    public <T> T toBean(Class<T> t);

    public Map toMap();

    public  JSONObject fromBean(Object bean);

    public  JSONObject fromMap(Map<String, Object> map);
}
