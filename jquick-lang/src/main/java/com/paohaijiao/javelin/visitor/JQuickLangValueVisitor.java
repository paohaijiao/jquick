package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.parser.JQuickLangParser;


public class JQuickLangValueVisitor extends JQuickLangCoreVisitor {
    @Override
    public Object visitVariables(JQuickLangParser.VariablesContext ctx) {
        String var=ctx.id().getText();
        Object value=this.context.get(var);
        Assert.notNull(value,"Variable "+var+" is not initialized");
        return value;
    }
    @Override
    public Object visitId(JQuickLangParser.IdContext ctx) {
        return ctx.ID().getText();
    }


}
