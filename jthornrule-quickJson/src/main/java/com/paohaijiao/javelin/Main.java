package com.paohaijiao.javelin;

import com.paohaijiao.javelin.adaptor.JThornRuleAdaptor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.executor.JSONExecutor;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.obj.JsonBean;
import com.paohaijiao.javelin.obj.JsonResponse;
import com.paohaijiao.javelin.resource.JThornRuleReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleReSourceFileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JSONExecutor executor = new JSONExecutor();
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleReSourceFileReader("rule.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            JsonResponse jsonObject = executor.execute(context.getRuleContent());
//            JsonBean jsonBean=jsonObject.toBean(JsonBean.class);
//            Map map=jsonObject.toMap();
//            JSONObject obj=new JSONObject().fromBean(jsonBean);
//            JSONObject newMap=new JSONObject().fromMap(map);
//            System.out.println("结果: " + jsonObject);
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
    public  String readFileFromClasspath(String fileName) {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
