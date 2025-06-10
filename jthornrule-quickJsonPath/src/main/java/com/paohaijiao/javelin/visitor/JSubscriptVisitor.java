package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JScriptContext;
import com.paohaijiao.javelin.bean.JSlice;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import javax.script.ScriptContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSubscriptVisitor extends JExprVisitor{
    @Override
    public Object visitSubscript(JQuickJSONPathParser.SubscriptContext ctx) {
        if (ctx.number() != null) {
            BigDecimal numberDecimal= visitNumber(ctx.number());
            Integer number=numberDecimal.intValue();
            return number;
        } else if (ctx.stringLiteral() != null) {
            String fields= visitStringLiteral(ctx.stringLiteral());
            return fields;
        } else if (ctx.slice() != null) {
            JSlice slice= visitSlice(ctx.slice());
            return slice;
        } else if (ctx.filterExpression() != null) {
            return visitFilterExpression(ctx.filterExpression());
        } else if (ctx.scriptExpression() != null) {
            return visitScriptExpression(ctx.scriptExpression());
        } else if (ctx.getText().equals("*")) {
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
        List<Integer> numbers = ctx.number().stream()
                .map(num -> Integer.parseInt(num.getText()))
                .collect(Collectors.toList());
        Integer start = !numbers.isEmpty() ? numbers.get(0) : null;
        Integer end = numbers.size() > 1 ? numbers.get(1) : null;
        Integer step = numbers.size() > 2 ? numbers.get(2) : null;
        JSlice slice=new JSlice();
        slice.setStart(start);
        slice.setEnd(end);
        slice.setStep(step);
        return slice;
    }

    @Override
    public  List<Object> visitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx) {
        JQuickJSONPathParser.ExprContext filterCondition = ctx.expr();
        List<?> list=this.getList(this.currentJsonObject);
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

}
