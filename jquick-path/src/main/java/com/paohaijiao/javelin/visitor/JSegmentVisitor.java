package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;

public class JSegmentVisitor extends JSubscriptVisitor {

    @Override
    public Object visitIdentifierSegment(JQuickJSONPathParser.IdentifierSegmentContext ctx) {
        if (ctx.identifier() != null) {//pass
            String fieldName = ctx.identifier().getText();
            Object result =getValueByKey(this.currentJsonObject, fieldName);
            this.currentJsonObject=result;
        }else if (ctx.getChild(1).getText().equals("*")) {
            Object result = visitDotWildcard(this.currentJsonObject);
            this.currentJsonObject=result;
        }
        return this.currentJsonObject;
    }
    @Override
    public Object visitSubscriptSegment(JQuickJSONPathParser.SubscriptSegmentContext ctx) {
        if(null!=ctx.subscript()){
            Object result =  visitSubscript(ctx.subscript());
            this.currentJsonObject=result;
            return this.currentJsonObject;
        }
        Assert.throwNewException("visitSubscriptSegment exception");
        return null;
    }
    @Override
    public Object visitChildIdentifierSegment(JQuickJSONPathParser.ChildIdentifierSegmentContext ctx) {
        if(null!=ctx.identifier()){
            Object result =  visitRecursiveField(ctx.identifier(),this.currentJsonObject);
            this.currentJsonObject=result;
            return this.currentJsonObject;
        }
        Assert.throwNewException("visitSubscriptSegment exception");
        return null;
    }
    @Override
    public Object visitChildSubscriptSegment(JQuickJSONPathParser.ChildSubscriptSegmentContext ctx) {
        if(null!=ctx.subscript()){
            Object result =  visitSubscript(ctx.subscript());
            this.currentJsonObject=result;
            return this.currentJsonObject;
        }
        Assert.throwNewException("visitSubscriptSegment exception");
        return null;
    }




    private Object visitDotWildcard(Object current) {
        if (current instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) current;
            return new ArrayList<>(jsonObj.toMap().values());
        }
        else if (current instanceof List) {
            return ((List<?>) current);
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
