package org.paohaijiao.jstark.visitor;

import org.paohaijiao.jstark.obj.JSonObject;
import org.paohaijiao.jstark.parser.JSONBaseVisitor;
import org.paohaijiao.jstark.parser.JSONParser;

public class JSONCommonVisitor extends JSONBaseVisitor {
    @Override
    public JSonObject visitJson(JSONParser.JsonContext ctx) {
        if(null!=ctx.value()) {
            return visitValue(ctx.value());
        }
        return new JSonObject();
    }

    @Override
    public JSonObject visitValue(JSONParser.ValueContext ctx) {
        JSonObject jSonObject=new JSonObject();
        if(null!=ctx.object()){
            return visitObject(ctx.object());
        }
        if(null!=ctx.array()){
            return visitArray(ctx.array());
        }
        if(null!=ctx.string){
            return visitArray(ctx.array());
        }
        return jSonObject;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public JSonObject visitObject(JSONParser.ObjectContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public JSonObject visitPair(JSONParser.PairContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public JSonObject visitArray(JSONParser.ArrayContext ctx) { return visitChildren(ctx); }


}

