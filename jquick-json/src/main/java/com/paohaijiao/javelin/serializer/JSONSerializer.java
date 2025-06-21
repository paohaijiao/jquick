package com.paohaijiao.javelin.serializer;

public interface JSONSerializer {

    String serialize(Object object);

    <T> T deserialize(String json, Class<T> clazz);
}
