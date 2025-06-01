package com.paohaijiao.javelin.obj;

import java.util.*;

public class JSONArray implements List<JSONObject> {
    private final List<JSONObject> list;

    public JSONArray() {
        this.list = new ArrayList<>();
    }

    public JSONArray(int initialCapacity) {
        this.list = new ArrayList<>(initialCapacity);
    }

    public JSONArray(List<JSONObject> list) {
        this.list = new ArrayList<>(list);
    }

    // 常用方法
    public String getString(int index) {
        Object value = list.get(index);
        return value == null ? null : value.toString();
    }

    public Integer getInteger(int index) {
        Object value = list.get(index);
        return value == null ? null : Integer.valueOf(value.toString());
    }

    public Long getLong(int index) {
        Object value = list.get(index);
        return value == null ? null : Long.valueOf(value.toString());
    }

    public Double getDouble(int index) {
        Object value = list.get(index);
        return value == null ? null : Double.valueOf(value.toString());
    }

    public Boolean getBoolean(int index) {
        JSONObject value = list.get(index);
        return value == null ? null : Boolean.valueOf(value.toString());
    }

    public JSONObject getJSONObject(int index) {
        JSONObject value = list.get(index);
        if (value instanceof JSONObject) {
            return (JSONObject) value;
        }
        if (value instanceof Map) {
            return new JSONObject((Map<String, Object>) value);
        }
        return null;
    }

    public JSONArray getJSONArray(int index) {
        Object value = list.get(index);
        if (value instanceof JSONArray) {
            return (JSONArray) value;
        }
        if (value instanceof List) {
            return new JSONArray((List<JSONObject>) value);
        }
        return null;
    }

    // 实现List接口的方法
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<JSONObject> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(JSONObject o) {
        return list.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JSONObject> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends JSONObject> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public JSONObject get(int index) {
        return list.get(index);
    }

    @Override
    public JSONObject set(int index, JSONObject element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, JSONObject element) {
        list.add(index, element);
    }

    @Override
    public JSONObject remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<JSONObject> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<JSONObject> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<JSONObject> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    // 转换为JSON字符串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (Object value : list) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            if (value == null) {
                sb.append("null");
            } else if (value instanceof String) {
                sb.append("\"").append(JSONObject.escape((String) value)).append("\"");
            } else if (value instanceof Number || value instanceof Boolean) {
                sb.append(value);
            } else {
                sb.append(value.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
