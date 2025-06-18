package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickExcelBaseVisitor;
import com.paohaijiao.javelin.parser.JQuickExcelParser;
import com.paohaijiao.javelin.util.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

public class JQuickExcelCoreVisitor extends JQuickExcelBaseVisitor {

    protected ContextParams context;

    protected Cell cell;

    @Override
    public String visitFileName(JQuickExcelParser.FileNameContext ctx) {
        if(ctx.STRING() != null) {
            String fileName = StringUtils.trim(ctx.STRING().getText());
            return fileName;
        }
        Assert.throwNewException("Invalid file name");
        return null;
    }
    @Override
    public String visitIdentifier(JQuickExcelParser.IdentifierContext ctx) {
        if(ctx.ID() != null) {
            String varName = StringUtils.trim(ctx.ID().getText());
            return varName;
        }
        Assert.throwNewException("Invalid varName");
        return null;
    }
    @Override
    public String visitDestination(JQuickExcelParser.DestinationContext ctx) {
        if(ctx.identifier() != null) {
            String varName = StringUtils.trim(ctx.identifier().getText());
            return varName;
        }
        Assert.throwNewException("Invalid Destination");
        return null;
    }
    @Override
    public Object visitVariable(JQuickExcelParser.VariableContext ctx) {
        if (ctx.identifier() != null) {
            String varName = visitIdentifier(ctx.identifier());
            return this.context.get(varName);
        }
        Assert.throwNewException("Invalid Variable");
        return null;
    }

}
