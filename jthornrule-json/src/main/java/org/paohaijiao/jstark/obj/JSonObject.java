package org.paohaijiao.jstark.obj;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JSonObject implements Map<String, Object> {
    private final Map<String, Object> map;

    public JSonObject() {
        this.map = new LinkedHashMap<>();
    }

    public JSonObject(int initialCapacity) {
        this.map = new LinkedHashMap<>(initialCapacity);
    }

    public JSonObject(Map<String, Object> map) {
        this.map = new LinkedHashMap<>(map);
    }

    // 常用方法
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

    public JSonObject getJSONObject(String key) {
        Object value = map.get(key);
        if (value instanceof JSonObject) {
            return (JSonObject) value;
        }
        if (value instanceof Map) {
            return new JSonObject((Map<String, Object>) value);
        }
        return null;
    }

    // 实现Map接口的方法
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

    // 转换为JSON字符串
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
    private String escape(String s) {
        if (s == null) return null;
        return s.replace("\"", "\\\"")
                .replace("\\", "\\\\")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    // 静态工具方法
    public static JSonObject parseObject(String json) {
        // 简化的解析实现，实际FastJSON有复杂的解析器
        // 这里仅作为示例，实际使用时应该使用完整的JSON解析器
        JSonObject obj = new JSonObject();
        // 简单实现，仅处理基本格式: {"key":"value","key2":123}
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
        if (obj instanceof JSonObject) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSonObject((Map<String, Object>) obj).toString();
        }
        if (obj instanceof String) {
            return "\"" + obj.toString() + "\"";
        }
        return obj.toString();
    }
}
