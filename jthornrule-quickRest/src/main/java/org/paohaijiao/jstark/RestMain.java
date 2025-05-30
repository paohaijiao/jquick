package org.paohaijiao.jstark;

import org.paohaijiao.jstark.adaptor.JThornRuleAdaptor;
import org.paohaijiao.jstark.exception.AntlrExecutionException;
import org.paohaijiao.jstark.executor.JThornRuleQuickRestExecutor;
import org.paohaijiao.jstark.resource.JThornRuleReader;
import org.paohaijiao.jstark.resource.impl.JThornRuleReSourceFileReader;

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
        } catch (AntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
}
