package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JValueVisitor extends JSONPathCoreVisitor{

    @Override
    public Object visitVariable(JQuickJSONPathParser.VariableContext ctx) {
        if(null!=ctx.STRING()){
         return null;
        }
        return null;
    }
    @Override
    public BigDecimal visitNumber(JQuickJSONPathParser.NumberContext ctx) {
        if(null==ctx||null==ctx.NUMBER()){
            return null;
        }else{
            return new BigDecimal(ctx.NUMBER().getText());
        }
    }
    @Override
    public String visitStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx) {
        return ctx.STRING().getText();
    }
    @Override
    public Object visitLiteral(JQuickJSONPathParser.LiteralContext ctx) {
        if(null!=ctx.stringLiteral()){
            return visitStringLiteral(ctx.stringLiteral());
        }else if(null!=ctx.number()){
            return visitNumber(ctx.number());
        }else if("null".equals(ctx.getText())){
          return null;
        }else if("true".equals(ctx.getText())){
            return Boolean.TRUE;
        }else if("false".equals(ctx.getText())){
            return Boolean.FALSE;
        }
        Assert.throwNewException("the literal not support this type");
        return null;
    }
    @Override
    public Object visitIdentifier(JQuickJSONPathParser.IdentifierContext ctx) {
        String identifier = ctx.getText();
        if (identifier.equals("*")) {
            return handleWildcard();
        }
        return handleIdentifierAccess(identifier);
    }
    protected Object handleIdentifierAccess(String identifier) {
        if (currentJsonObject instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) currentJsonObject;
            return jsonObj.has(identifier) ? jsonObj.get(identifier) : null;
        }
        else if (currentJsonObject instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) currentJsonObject) {
                if (item instanceof JSONObject) {
                    JSONObject jsonItem = (JSONObject) item;
                    if (jsonItem.has(identifier)) {
                        results.add(jsonItem.get(identifier));
                    }
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }





}
