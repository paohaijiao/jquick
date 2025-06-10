package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;

public class JSegmentVisitor extends JSubscriptVisitor {



    /**
     * parse JSONPath express path Segment
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Void visitSegment(JQuickJSONPathParser.SegmentContext ctx) {
        // process .
        if (ctx.getChild(0).getText().equals(".")) {
            if (ctx.getChildCount() == 2) {
                if (ctx.identifier() != null) {
                    String fieldName = ctx.getText();
                    Object result =getValueByKey(this.currentJsonObject, fieldName);
                    this.currentJsonObject=result;
                } else if (ctx.getChild(1).getText().equals("*")) {
                    Object result = visitDotWildcard(this.currentJsonObject);
                    this.currentJsonObject=result;
                }
            }
        } else if (ctx.getChild(0).getText().equals("[")) {
            Object result =visitBracketNotation(ctx.subscript(), this.currentJsonObject);
            this.currentJsonObject=result;
        } else if (ctx.getChild(0).getText().equals("..")) {//recurse  ('..' identifier or '..' '[' subscript ']')
            if (ctx.identifier() != null) {
                Object result  = visitRecursiveField(ctx.identifier(), this.currentJsonObject);
                this.currentJsonObject=result;
            } else if (ctx.subscript() != null) {
                Object result = visitRecursiveBracketNotation(ctx.subscript(), this.currentJsonObject);
                this.currentJsonObject=result;
            }
        }
        return null;
    }
    private Object visitDotWildcard(Object current) {
        if (current instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) current;
            return new ArrayList<>(jsonObj.toMap().values());
        }
        else if (current instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) current) {
                if (item instanceof JSONObject) {
                    results.addAll(((JSONObject) item).toMap().values());
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }
    protected Object visitBracketNotation(JQuickJSONPathParser.SubscriptContext ctx, Object current) {
        if(ctx.number() != null) {//位置参数只能是List
            Integer number= visitNumber(ctx.number()).intValue();
            if (current instanceof List) {
                return ((List<?>) this.currentJsonObject).get(number);
            }
        }
        if (current == null) {
            return null;
        }
        if (current instanceof JSONObject) {
            return visitSubscript(ctx);
        }
        else if (current instanceof List) {
            if(ctx.number() != null) {
                //Integer number= visitSubscript(ctx);
            }

        }
        return null;
    }
    private Object visitRecursiveField(JQuickJSONPathParser.IdentifierContext ctx, Object current) {
        String fieldName = ctx.getText();
        List<Object> results = new ArrayList<>();
        collectFieldValuesRecursively(current, fieldName, results);
        return results.isEmpty() ? null : results;
    }
    private void collectFieldValuesRecursively(Object node, String fieldName, List<Object> results) {
        if (node == null) {
            return;
        }
        if (node instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) node;
            if (jsonObj.has(fieldName)) {
                results.add(jsonObj.get(fieldName));
            }
            for (Object value : jsonObj.toMap().values()) {
                collectFieldValuesRecursively(value, fieldName, results);
            }
        }
        else if (node instanceof List) {
            for (Object item : (List<?>) node) {
                collectFieldValuesRecursively(item, fieldName, results);
            }
        }
    }

}
