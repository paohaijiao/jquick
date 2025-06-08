package com.paohaijiao.javelin.test;

import com.paohaijiao.javelin.adaptor.JThornRuleAdaptor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;

import com.paohaijiao.javelin.executor.JSONExecutor;
import com.paohaijiao.javelin.executor.JSONPathExecutor;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.resource.JThornRuleReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleReSourceFileReader;


public class JSonPathMain {
    public static void main(String[] args) {
        JSONObject obj = getData();
        JSONPathExecutor executor = new JSONPathExecutor(obj);
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleReSourceFileReader("rule.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            JSONObject jsonObject = executor.execute(context.getRuleContent());
            System.out.println("结果: " + jsonObject);
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
    public  static JSONObject getData() {
        JSONExecutor executor = new JSONExecutor();
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleReSourceFileReader("data.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            JSONObject jsonObject = executor.execute(context.getRuleContent());
           return jsonObject;
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
        return null;
    }
}
