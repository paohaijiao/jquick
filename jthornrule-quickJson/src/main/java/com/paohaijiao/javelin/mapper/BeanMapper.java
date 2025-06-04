package com.paohaijiao.javelin.mapper;

import java.util.Map;

public interface BeanMapper {

    public <T> T toBean(Class<T> t);

    public Map toMap();

//    public Map toJson();
}
