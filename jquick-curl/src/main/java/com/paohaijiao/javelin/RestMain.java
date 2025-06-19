package com.paohaijiao.javelin;

import com.paohaijiao.javelin.adaptor.JThornRuleAdaptor;
import com.paohaijiao.javelin.exception.JAntlrExecutionException;
import com.paohaijiao.javelin.executor.JThornRuleQuickRestExecutor;
import com.paohaijiao.javelin.resource.JThornRuleReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleReSourceFileReader;

public class RestMain {
    public static void main(String[] args) {
        JThornRuleQuickRestExecutor executor = new JThornRuleQuickRestExecutor();
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleReSourceFileReader("rule.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            Object result = executor.execute(context.getRuleContent());
            System.out.println("结果: " + result);
        } catch (JAntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
}
