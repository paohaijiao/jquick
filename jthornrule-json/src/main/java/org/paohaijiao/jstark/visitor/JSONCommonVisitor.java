package org.paohaijiao.jstark.visitor;

import org.paohaijiao.jstark.obj.JSONObject;
import org.paohaijiao.jstark.parser.JSONBaseVisitor;
import org.paohaijiao.jstark.parser.JSONParser;

import javax.print.DocFlavor;
import java.math.BigDecimal;

public class JSONCommonVisitor extends JSONBaseVisitor {
    @Override
    public JSONObject visitJson(JSONParser.JsonContext ctx) {
        if(null!=ctx.value()) {
            return visitValue(ctx.value());
        }
        return new JSONObject();
    }

    @Override
    public JSONObject visitValue(JSONParser.ValueContext ctx) {
        JSONObject jSonObject=new JSONObject();
//        if(null!=ctx.object()){
//            return visitObject(ctx.object());
//        }
//        if(null!=ctx.array()){
//            return visitArray(ctx.array());
//        }
//        if(null!=ctx.string()){
//            return visitString(ctx.string());
//        }
//        if(null!=ctx.number()){
//            return visitNumber(ctx.number());
//        }
//        if(null!=ctx.bool()){
//            return visitBool(ctx.bool());
//        }
        if(null!=ctx.null_()){
            return visitNull(ctx.null_());
        }
        return jSonObject;
    }

//    @Override
//    public JSonObject visitObject(JSONParser.ObjectContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public JSONObject visitPair(JSONParser.PairContext ctx) {
        JSONObject jSonObject=new JSONObject();
        if(null!=ctx.string()){
//            return visitString(ctx.string());
        }
        if(null!=ctx.value()){
            return visitValue(ctx.value());
        }
        return jSonObject;
    }

    @Override
    public JSONObject visitArray(JSONParser.ArrayContext ctx) {
//        return visitChildren(ctx);
        return null;
    }

    @Override
    public String visitString(JSONParser.StringContext ctx) {
        return ctx.getText();
    }

    @Override
    public BigDecimal visitNumber(JSONParser.NumberContext ctx) {
        return new BigDecimal(ctx.getText());
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

