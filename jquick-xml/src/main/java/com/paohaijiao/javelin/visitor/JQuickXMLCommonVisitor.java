package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.model.JKeyValueModel;
import com.paohaijiao.javelin.obj.JSONArray;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickXMLParser;

public class JQuickXMLCommonVisitor extends JQuickXmlCoreVisitor {

    @Override
    public JSONObject visitDocument(JQuickXMLParser.DocumentContext ctx) {
        if (ctx.element() != null) {
             return visitElement(ctx.element());
        }
        return null;
    }
    @Override
    public JSONObject visitProlog(JQuickXMLParser.PrologContext ctx) {
        return new JSONObject();
    }
    @Override
    public Object visitContent(JQuickXMLParser.ContentContext ctx) {
        Object returnValue=null;
        JSONArray array=new JSONArray();
        String text = ctx.getText();
        System.out.println(text);
        if(ctx.element() != null) {
            for (JQuickXMLParser.ElementContext ele:ctx.element()){
               JSONObject result= visitElement(ele);
               array.add(result);
            }
            returnValue= array;
        }else if(ctx.chardata() != null) {

            for (JQuickXMLParser.ChardataContext ele:ctx.chardata()){
                String ctxString = ele.getText();
                String  result= visitChardata(ele);
                returnValue= result;
            }
        }
        return returnValue;
    }

    @Override
    public JSONObject visitElement(JQuickXMLParser.ElementContext ctx) {
        JSONObject json = new JSONObject();
        String key = ctx.Name(0).getText();
        String  name=ctx.getText();
        Object value = null;
        if (ctx.content() != null) {
            value=visitContent(ctx.content());
        }
        json.put(key,value);
        return json;
    }

    @Override
    public JSONObject  visitReference(JQuickXMLParser.ReferenceContext ctx) {
        JSONObject json = new JSONObject();
        if (ctx.EntityRef() != null) {
            json.put(entityRef, ctx.EntityRef().getText());
        } else {
            json.put(charRef, ctx.CharRef().getText());
        }
        return json;
    }

    @Override
    public JSONObject visitAttribute(JQuickXMLParser.AttributeContext ctx) {
        JSONObject attribute = new JSONObject();
        attribute.put(name, ctx.Name().getText());
        String value = ctx.STRING().getText();
        attribute.put(string, value.substring(1, value.length() - 1));
        return attribute;
    }

    @Override
    public String  visitChardata(JQuickXMLParser.ChardataContext ctx) {
        String str=ctx.getText();
        if (ctx.TEXT() != null) {
            String text= ctx.TEXT().getText();
            return text;
        }
        return null;
    }
    @Override
    public JSONObject  visitMisc(JQuickXMLParser.MiscContext ctx) {
        JSONObject json=new JSONObject();
        if (ctx.COMMENT() != null) {
             json.put(comment, ctx.COMMENT().getText());
            return json;
        } else if (ctx.PI() != null) {
            json.put(pi, ctx.PI().getText());
            return json;
        } else {
            json.put(seaWs, ctx.SEA_WS().getText());
            return json;
        }
    }


}
