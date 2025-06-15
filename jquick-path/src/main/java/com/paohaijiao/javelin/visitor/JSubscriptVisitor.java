package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JScriptContext;
import com.paohaijiao.javelin.bean.JSlice;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;
import com.paohaijiao.javelin.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class JSubscriptVisitor extends JExprVisitor {
    @Override
    public Object visitSubscript(JQuickJSONPathParser.SubscriptContext ctx) {
        if (ctx.number() != null) {//pass
            BigDecimal numberDecimal = visitNumber(ctx.number());
            Integer number = numberDecimal.intValue();
            if (number >= 0) {
                Object result = getValueByIndex(this.currentJsonObject, number);
                this.currentJsonObject=result;
                return result;
            } else {
                List<?> list = getList(this.currentJsonObject);
                Collections.reverse(list);
                number = Math.abs(number);
                Object result = getValueByIndex(list, number);
                this.currentJsonObject=result;
                return result;
            }

        } else if (ctx.stringLiteral() != null) {//pass
            String fields = visitStringLiteral(ctx.stringLiteral());
            String fieldName = StringUtils.trim(fields);
            Object result = getValueByKey(this.currentJsonObject, fieldName);
            this.currentJsonObject=result;
            return result;
        } else if (ctx.slice() != null) {
            JSlice slice = visitSlice(ctx.slice());
            List<?> newList=slice(this.getList(this.currentJsonObject), slice.getStart(), slice.getEnd(), slice.getStep());
            this.currentJsonObject=newList;
            return newList;

        } else if (ctx.filterExpression() != null) {
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
    public JSlice visitSlice(JQuickJSONPathParser.SliceContext ctx) {
       JSlice slice = new JSlice();
        if(null!=ctx.start()){
            Integer number=visitStart(ctx.start());
            slice.setStart(number);
        }
        if(null!=ctx.end()){
            Integer number=visitEnd(ctx.end());
            slice.setEnd(number);
        }
        if(null!=ctx.step()){
            Integer number=visitStep(ctx.step());
            slice.setStep(number);
        }
        return slice;
    }

    @Override
    public List<Object> visitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx) {
        JQuickJSONPathParser.ExprContext filterCondition = ctx.expr();
        List<?> list = this.getList(this.currentJsonObject);
        List<Object> result = new ArrayList<>();
        for (Object item : list) {
            Object conditionResult = visit(filterCondition);
            if (conditionResult instanceof Boolean && (Boolean) conditionResult) {
                result.add(item);
            }
        }
        return result;
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
    @Override
    public Integer visitStart(JQuickJSONPathParser.StartContext ctx) {
        BigDecimal number=visitNumber(ctx.number());
        return null==number?null:number.intValue();
    }
    @Override
    public Integer visitEnd(JQuickJSONPathParser.EndContext ctx) {
        BigDecimal number=visitNumber(ctx.number());
        return null==number?null:number.intValue();
    }
    @Override
    public Integer visitStep(JQuickJSONPathParser.StepContext ctx) {
        BigDecimal number=visitNumber(ctx.number());
        return null==number?null:number.intValue();
    }




}
