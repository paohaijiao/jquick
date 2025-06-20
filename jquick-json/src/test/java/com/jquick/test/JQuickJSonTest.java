package com.jquick.test;

import com.paohaijiao.javelin.adaptor.JQuickAdaptor;
import com.paohaijiao.javelin.exception.JAntlrExecutionException;
import com.paohaijiao.javelin.executor.JSONExecutor;
import com.paohaijiao.javelin.model.JsonResponse;
import com.paohaijiao.javelin.param.JContext;
import com.paohaijiao.javelin.resource.JQuickReader;
import com.paohaijiao.javelin.resource.impl.JQuickReSourceFileReader;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class JQuickJSonTest {

    @Test
    @Ignore
    public void test1() throws IOException {
        JContext jcontext = new JContext();
        jcontext.put("name","paohaijiao");
        JSONExecutor executor = new JSONExecutor(jcontext);
        executor.addErrorListener(error -> {
        });
        try {
            JQuickReader fileReader = new JQuickReSourceFileReader("rule.txt");
            JQuickAdaptor context = new JQuickAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            JsonResponse jsonObject = executor.execute(context.getRuleContent());
            System.out.println(jsonObject);
        } catch (JAntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
 }
    @Test
    @Ignore
    public void test2() throws IOException {
        JContext jcontext = new JContext();
        jcontext.put("name","paohaijiao");
        JSONExecutor executor = new JSONExecutor(jcontext);
        executor.addErrorListener(error -> {
        });
        try {
            JQuickReader fileReader = new JQuickReSourceFileReader("rule1.txt");
            JQuickAdaptor context = new JQuickAdaptor(fileReader);
            System.out.println(context.getRuleContent());
            JsonResponse jsonObject = executor.execute(context.getRuleContent());
            System.out.println(jsonObject);
        } catch (JAntlrExecutionException e) {
            System.err.println("解析失败: " + e.getMessage());
            e.getErrors().forEach(err ->
                    System.err.println(" - " + err.getMessage()));
        }
    }
}
