package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;

public class JSubscriptVisitor extends JExprVisitor{
    @Override
    public Object visitSubscript(JQuickJSONPathParser.SubscriptContext ctx) {
        if (ctx.number() != null) {
            return visitNumber(ctx.number());
        } else if (ctx.stringLiteral() != null) {
            return visitStringLiteral(ctx.stringLiteral());
        } else if (ctx.slice() != null) {
            return visitSlice(ctx.slice());
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
    public Object visitSlice(JQuickJSONPathParser.SliceContext ctx) {
        Object current = currentJsonObject;
        if (!(current instanceof List)) {
            return null;
        }
        List<?> list = (List<?>) current;
        int size = list.size();
        Integer start = ctx.getChildCount() > 0 && ctx.getChild(0) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(0).getText()) : null;
        Integer end = ctx.getChildCount() > 2 && ctx.getChild(2) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(2).getText()) : null;
        Integer step = ctx.getChildCount() > 4 && ctx.getChild(4) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(4).getText()) : 1;

        start = start != null ? (start < 0 ? size + start : start) : 0;
        end = end != null ? (end < 0 ? size + end : end) : size;
        start = Math.max(0, Math.min(start, size));
        end = Math.max(0, Math.min(end, size));
        List<Object> result = new ArrayList<>();
        if (step > 0) {
            for (int i = start; i < end; i += step) {
                result.add(list.get(i));
            }
        } else if (step < 0) {
            for (int i = end - 1; i >= start; i += step) {
                result.add(list.get(i));
            }
        }

        return result;
    }
}
