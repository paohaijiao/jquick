package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JScriptContext;
import com.paohaijiao.javelin.bean.JSlice;
import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;
import com.paohaijiao.javelin.util.ObjectConverter;
import com.paohaijiao.javelin.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class JSubscriptVisitor extends JExprVisitor {

    @Override
    public Object visitSubscript(JQuickJSONPathParser.SubscriptContext ctx) {
        if (ctx.number() != null) {//pass
            BigDecimal numberDecimal = visitNumber(ctx.number());
            Integer index = numberDecimal.intValue();
            if (index >= 0) {
                Object result = getValueByIndex(this.currentJsonObject, (Integer) index);
                return result;
            } else {
                index = Math.abs(index);
                List<?> list = this.getList(this.currentJsonObject);
                Collections.reverse(list);
                Object result = getValueByIndex(list, index);
                return result;
            }
        } else if (ctx.stringLiteral() != null) {//pass
            String fields = visitStringLiteral(ctx.stringLiteral());
            String fieldName = StringUtils.trim(fields);
            Object result = getValueByKey(this.currentJsonObject, fieldName);
            return result;
        } else if (ctx.slice() != null) {//pass
            JSlice slice = visitSlice(ctx.slice());
            List<?> list = this.getList(this.currentJsonObject);
            List<?> data = slice(list, slice.getStart(), slice.getEnd(), slice.getStep());
            return data;
        } else if (ctx.filterExpression() != null) {//pass
            return visitFilterExpression(ctx.filterExpression());
        } else if (ctx.scriptExpression() != null) {
            return visitScriptExpression(ctx.scriptExpression());
        } else if (ctx.getText().equals("*")) {//pass
            return visitWildcard();
        } else if (ctx.subscript() != null && ctx.getChild(0).getText().equals(",")) {
            // mutiple subscript（ like [1,2,3]）
            List<Object> results = new ArrayList<>();
            for (JQuickJSONPathParser.SubscriptContext subCtx : ctx.subscript()) {
                Object result = visitSubscript(subCtx);
                if (result != null) {
                    if (result instanceof List) {
                        results.addAll((List<?>) result);
                    } else {
                        results.add(result);
                    }
                }
            }
            return results;
        }
        return null;
    }



    @Override
    public List<?> visitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx) {
        List<Object> list=new ArrayList<>();
        List<?> data=this.getList(this.currentJsonObject);
        for(Object o:data){
            this.currentJsonObject=o;
            if(ctx.expr()!=null){
              Object obj=  visit((ctx.expr()));
              if(obj instanceof Boolean){
                  Boolean bool=  ObjectConverter.assign(obj,Boolean.class);
                  if(bool){
                      list.add(o);
                  }
              }else {
                  Assert.throwNewException("FilterExpression only accept boolean express");
              }
            }
        }
        return list;
    }

    @Override
    public Object visitScriptExpression(JQuickJSONPathParser.ScriptExpressionContext ctx) {
        JQuickJSONPathParser.ExprContext exprCtx = ctx.expr();
        JScriptContext scriptContext = createScriptContext();
        return visit(exprCtx);

    }

    private JScriptContext createScriptContext() {
        JScriptContext context = new JScriptContext();
        context.addVariable("$", this.rootJsonObject);
        context.addVariable("@", this.currentJsonObject);
        context.addFunction("length", args -> {
            if (args[0] instanceof Collection) {
                return ((Collection<?>) args[0]).size();
            } else if (args[0] instanceof Map) {
                return ((Map<?, ?>) args[0]).size();
            } else if (args[0] instanceof String) {
                return ((String) args[0]).length();
            }
            return 0;
        });

        return context;
    }





}
