package com.paohaijiao.javelin.common;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickLangParser;
import com.paohaijiao.javelin.visitor.JQuickLangAssignVisitor;

public class JQuickLangCommonVisitor extends JQuickLangAssignVisitor {
    public JQuickLangCommonVisitor(ContextParams context){
        this.context = context;
    }
    public JQuickLangCommonVisitor(){
        this.context = new ContextParams();
    }

    @Override
    public Object visitRule(JQuickLangParser.RuleContext ctx) {
        if(null!=ctx.assignment()){
            visit(ctx.assignment());
            return null;
        } else if (ctx.returnStatement() != null) {
            return visit(ctx.returnStatement());
        }
        Assert.throwNewException("invalid rule syntax");
        return null;
    }
    @Override
    public Object visitStatement(JQuickLangParser.StatementContext ctx) {
        Object result =null;
        for (JQuickLangParser.RuleContext r:ctx.rule_()){
            result=visitRule(r);
        }
        return result;
    }

}
