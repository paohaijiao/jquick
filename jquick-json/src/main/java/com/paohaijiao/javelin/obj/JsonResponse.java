package com.paohaijiao.javelin.obj;

import com.paohaijiao.javelin.util.BeanCopyUtils;
import lombok.Data;

import java.util.List;


@Data
public class JsonResponse {
    private Object data;
    private String type;
    public JsonResponse getData() {
        JsonResponse response = new JsonResponse();
        if (data instanceof JSONObject) {
            response.setData((JSONObject)data);
            response.setType("object");
        } else {
             List<JSONObject> list= BeanCopyUtils.copyList((List)data,JSONObject.class);
            response.setData(new JSONArray(list));
            response.setType("array");
        }
        return response;
    }
}
