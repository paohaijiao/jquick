package com.paohaijiao.javelin.obj;

import com.paohaijiao.javelin.mapper.BeanMapper;
import com.paohaijiao.javelin.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

public class JSONObject implements Map<String, Object>, BeanMapper {
    private final Map<String, Object> map;

    public JSONObject() {
        this.map = new LinkedHashMap<>();
    }

    public JSONObject(int initialCapacity) {
        this.map = new LinkedHashMap<>(initialCapacity);
    }

    public JSONObject(Map<String, Object> map) {
        this.map = new LinkedHashMap<>(map);
    }

    public String getString(String key) {
        Object value = map.get(key);
        return value == null ? null : value.toString();
    }

    public Integer getInteger(String key) {
        Object value = map.get(key);
        return value == null ? null : Integer.valueOf(value.toString());
    }

    public Long getLong(String key) {
        Object value = map.get(key);
        return value == null ? null : Long.valueOf(value.toString());
    }

    public Double getDouble(String key) {
        Object value = map.get(key);
        return value == null ? null : Double.valueOf(value.toString());
    }

    public Boolean getBoolean(String key) {
        Object value = map.get(key);
        return value == null ? null : Boolean.valueOf(value.toString());
    }

    public JSONObject getJSONObject(String key) {
        Object value = map.get(key);
        if (value instanceof JSONObject) {
            return (JSONObject) value;
        }
        if (value instanceof Map) {
            return new JSONObject((Map<String, Object>) value);
        }
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Object> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            sb.append("\"").append(escape(entry.getKey())).append("\":");
            Object value = entry.getValue();
            if (value == null) {
                sb.append("null");
            } else if (value instanceof String) {
                sb.append("\"").append(escape((String) value)).append("\"");
            } else if (value instanceof Number || value instanceof Boolean) {
                sb.append(value);
            } else {
                sb.append(value.toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // 简单的字符串转义
    public static String escape(String s) {
        if (s == null) return null;
        return s.replace("\"", "\\\"")
                .replace("\\", "\\\\")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public static JSONObject parseObject(String json) {
        JSONObject obj = new JSONObject();
        String content = json.trim().substring(1, json.length() - 1);
        String[] entries = content.split(",");
        for (String entry : entries) {
            String[] kv = entry.split(":", 2);
            String key = kv[0].trim().replaceAll("^\"|\"$", "");
            String value = kv[1].trim();
            if (value.startsWith("\"") && value.endsWith("\"")) {
                obj.put(key, value.substring(1, value.length() - 1));
            } else if (value.equals("true") || value.equals("false")) {
                obj.put(key, Boolean.valueOf(value));
            } else if (value.equals("null")) {
                obj.put(key, null);
            } else {
                try {
                    obj.put(key, Long.valueOf(value));
                } catch (NumberFormatException e) {
                    try {
                        obj.put(key, Double.valueOf(value));
                    } catch (NumberFormatException e2) {
                        obj.put(key, value);
                    }
                }
            }
        }
        return obj;
    }

    public static String toJSONString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof JSONObject) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map<String, Object>) obj).toString();
        }
        if (obj instanceof String) {
            return "\"" + obj.toString() + "\"";
        }
        return obj.toString();
    }

    @Override
    public <T> T toBean(Class<T> t) {
        try {
            T instance = ReflectionUtils.newInstance(t);
            List<Field> fields = ReflectionUtils.getAllFields(t);
            for (Field field : fields) {
                String fieldName = field.getName();
                if (this.containsKey(fieldName)) {
                    Object value = this.get(fieldName);
                    Class<?> fieldType = field.getType();
                    if (value instanceof Map && !Map.class.isAssignableFrom(fieldType)) {
                        JSONObject nestedJson = new JSONObject((Map<String, Object>) value);
                        value = nestedJson.toBean(fieldType);
                    }
                    else if (fieldType.isEnum() && value instanceof String) {
                        value = ReflectionUtils.getEnumByName((Class<? extends Enum>) fieldType, (String) value);
                    }
                    else if (value != null && !fieldType.isAssignableFrom(value.getClass())) {
                        if (fieldType == Integer.class || fieldType == int.class) {
                            value = this.getInteger(fieldName);
                        } else if (fieldType == Long.class || fieldType == long.class) {
                            value = this.getLong(fieldName);
                        } else if (fieldType == Double.class || fieldType == double.class) {
                            value = this.getDouble(fieldName);
                        } else if (fieldType == Boolean.class || fieldType == boolean.class) {
                            value = this.getBoolean(fieldName);
                        } else if (fieldType == String.class) {
                            value = this.getString(fieldName);
                        }
                    }
                    ReflectionUtils.setFieldValue(instance, fieldName, value);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("转换JSON对象为Bean失败", e);
        }
    }

    @Override
    public Map toMap() {
        return deepCopyMap(this.map);
    }
    private Map<String, Object> deepCopyMap(Map<String, Object> original) {
        Map<String, Object> copy = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : original.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Map) {
                copy.put(entry.getKey(), deepCopyMap((Map<String, Object>) value));
            } else if (value instanceof List) {
                copy.put(entry.getKey(), new ArrayList<>((List<?>) value));
            } else {
                copy.put(entry.getKey(), value);
            }
        }
        return copy;
    }
}
