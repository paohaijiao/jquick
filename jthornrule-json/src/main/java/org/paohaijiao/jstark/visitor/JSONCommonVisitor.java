package org.paohaijiao.jstark.visitor;

import javafx.util.converter.ShortStringConverter;
import org.paohaijiao.jstark.obj.JSONObject;
import org.paohaijiao.jstark.obj.JSonKeyValue;
import org.paohaijiao.jstark.parser.JSONBaseVisitor;
import org.paohaijiao.jstark.parser.JSONParser;
import org.paohaijiao.jstark.util.ObjectConverter;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.List;

public class JSONCommonVisitor extends JSONBaseVisitor {
    @Override
    public JSONObject visitJson(JSONParser.JsonContext ctx) {
        JSONObject jsonObject = new JSONObject();
        Object result = null;
        if(null!=ctx.value()) {
            result=visitValue(ctx.value());
             jsonObject=ObjectConverter.assign(result, JSONObject.class);
        }
        return jsonObject;
    }

    @Override
    public Object visitValue(JSONParser.ValueContext ctx) {
        if(null!=ctx.object()){
            Object obj=visitObject(ctx.object());
        }
        if(null!=ctx.array()){
            return visitArray(ctx.array());
        }
        if(null!=ctx.string()){
            return visitString(ctx.string());
        }
        if(null!=ctx.number()){
            return visitNumber(ctx.number());
        }
        if(null!=ctx.bool()){
            return visitBool(ctx.bool());
        }
        if(null!=ctx.null_()){
            return visitNull(ctx.null_());
        }
        return null;
    }




    @Override
    public JSONObject visitArray(JSONParser.ArrayContext ctx) {
//        return visitChildren(ctx);
        return null;
    }
    @Override
    public JSONObject visitObject(JSONParser.ObjectContext ctx) {
        JSONObject jsonObject=new JSONObject();
        List<JSONParser.PairContext> pair=ctx.pair();
        for (int i = 0; i < pair.size(); i++) {
            JSonKeyValue keyValue=visitPair(ctx.pair(i));
            jsonObject.put(keyValue.getKey(), keyValue.getValue());
        }
        return jsonObject;
    }

    @Override
    public JSonKeyValue visitPair(JSONParser.PairContext ctx) {
        JSonKeyValue jSonObject=new JSonKeyValue();
        String key=null;
        Object value=null;
        if(null!=ctx.string()){
            key= visitString(ctx.string());
        }
        if(null!=ctx.value()){
            value= visitValue(ctx.value());
        }
        jSonObject.setKey(key);
        jSonObject.setValue(value);
        return jSonObject;
    }
    @Override
    public String visitString(JSONParser.StringContext ctx) {
        String str= ctx.getText();
        return str;
    }

    @Override
    public BigDecimal visitNumber(JSONParser.NumberContext ctx) {
        BigDecimal bigDecimal= new BigDecimal(ctx.getText());
        return bigDecimal;
    }

    @Override
    public Boolean visitBool(JSONParser.BoolContext ctx) {
        String str=ctx.getText();
        if(str.equals("true") ) {
            return true;
        } else if (str.equals("false") ) {
            return true;
        }else{
            return null;
        }
    }

    @Override
    public JSONObject visitNull(JSONParser.NullContext ctx) {
        return null;
    }

}

