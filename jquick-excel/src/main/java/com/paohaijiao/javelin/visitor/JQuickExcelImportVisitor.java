package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.parser.JQuickExcelParser;

import java.io.InputStream;

public class JQuickExcelImportVisitor<Object> extends JquickExcelImportOptionVisitor{


    public JQuickExcelImportVisitor(String fileName) {
        this.in=getInputStreamByFileName(fileName);
        this.workbook =getWorkbookByInputStream(this.in);
    }
    public JQuickExcelImportVisitor(InputStream in) {
        this.in = in;
        this.workbook =getWorkbookByInputStream(this.in);
    }

    @Override
    public Void visitImportConfig(JQuickExcelParser.ImportConfigContext ctx) {
        if(null!=ctx.STRING()){
            String fileName=removeQuotes(ctx.STRING().getText());
            this.jQuickExcelImport.setFileName(fileName);
            this.in=getInputStreamByFileName(fileName);
            this.workbook =getWorkbookByInputStream(this.in);
        }
        if (ctx.importOption() != null) {
            for (JQuickExcelParser.ImportOptionContext option : ctx.importOption()) {
                 visit(option);
            }
        }
        return null;
    }
    @Override
    public Void visitImportOption(JQuickExcelParser.ImportOptionContext ctx) {
        if (ctx.sheetOption() != null) {
             visitSheetOption(ctx.sheetOption());
        } else if (ctx.headerOption() != null) {
             visitHeaderOption(ctx.headerOption());
        } else if (ctx.rangeOption() != null) {
            visitRangeOption(ctx.rangeOption());
        } else if (ctx.mappingOption() != null) {
            visitMappingOption(ctx.mappingOption());
        } else if (ctx.transformOption() != null) {
             visitTransformOption(ctx.transformOption());
        }
        throw new IllegalArgumentException("Unknown import option type");
    }
}
