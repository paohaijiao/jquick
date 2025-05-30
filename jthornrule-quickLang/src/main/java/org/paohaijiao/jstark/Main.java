package org.paohaijiao.jstark;

import org.paohaijiao.jstark.adaptor.JThornRuleAdaptor;
import org.paohaijiao.jstark.exception.AntlrExecutionException;
import org.paohaijiao.jstark.executor.JThornRuleQuickLangExecutor;
import org.paohaijiao.jstark.resource.JThornRuleReader;
import org.paohaijiao.jstark.resource.impl.JThornRuleFileReader;

public class Main {
    public static void main(String[] args) {
        JThornRuleQuickLangExecutor executor = new JThornRuleQuickLangExecutor();
        executor.addErrorListener(error -> {
            System.err.printf("错误: 行%d:%d - %s%n",
                    error.getLine(), error.getCharPosition(), error.getMessage());
            System.err.println("规则栈: " + error.getRuleStack());
        });
        try {
            JThornRuleReader fileReader = new JThornRuleFileReader("rule.txt");
            JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            Object result = executor.execute(context.getRuleContent());
            System.out.println("结果: " + result);
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
}
