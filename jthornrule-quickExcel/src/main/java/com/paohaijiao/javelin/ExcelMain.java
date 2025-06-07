package com.paohaijiao.javelin;

import cn.hutool.json.JSONObject;
import com.paohaijiao.javelin.adaptor.JThornRuleAdaptor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.executor.JThornRuleQuickExcelExecutor;
import com.paohaijiao.javelin.resource.JThornRuleReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleReSourceFileReader;

import java.util.Map;

public class ExcelMain {
    public static void main(String[] args) {
        JThornRuleQuickExcelExecutor executor = new JThornRuleQuickExcelExecutor();
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleReSourceFileReader("rule.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            Object jsonObject = executor.execute(context.getRuleContent());
            System.out.println("结果: " + jsonObject);
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
}
