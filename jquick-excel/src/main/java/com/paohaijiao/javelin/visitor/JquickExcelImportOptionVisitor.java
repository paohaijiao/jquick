package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JQuickImportFieldMapping;
import com.paohaijiao.javelin.enums.JQuickExcelHeaderEnums;
import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.parser.JQuickExcelParser;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JquickExcelImportOptionVisitor extends JQuickExcelCommonVisitor<Object> {
    protected InputStream in=null;
    protected Workbook workbook=null;
    protected Sheet sheet =null;

    protected JQuickExcelHeaderEnums header = JQuickExcelHeaderEnums.YES;
    @Override
    public Sheet visitSheetOption(JQuickExcelParser.SheetOptionContext ctx) {
        if(ctx.STRING() != null){
            this.sheet=workbook.getSheet(ctx.STRING().getText());
            return sheet;
        }
        if(ctx.INTEGER() != null){
            this.sheet=workbook.getSheetAt(Integer.valueOf(ctx.INTEGER().getText()));
            return sheet;
        }
        Assert.throwNewException("Invalid sheet option");
        return null;
    }

    @Override
    public JQuickExcelHeaderEnums visitHeaderOption(JQuickExcelParser.HeaderOptionContext ctx) {
        if (ctx.INTEGER() != null) {
            return JQuickExcelHeaderEnums.codeOf(ctx.INTEGER().getText());
        } else {
            return JQuickExcelHeaderEnums.nameOf(ctx.getText());
        }
    }



    @Override
    public   List<JQuickImportFieldMapping> visitMappingOption(JQuickExcelParser.MappingOptionContext ctx) {
       List<JQuickImportFieldMapping> fieldMappingList=new ArrayList<>();
        for (JQuickExcelParser.FieldMappingContext mapping : ctx.fieldMapping()) {
            JQuickImportFieldMapping jQuickImportFieldMapping=visitFieldMapping(mapping);
            fieldMappingList.add(jQuickImportFieldMapping);
        }
        return fieldMappingList;
    }
    @Override
    public JQuickImportFieldMapping visitFieldMapping(JQuickExcelParser.FieldMappingContext ctx) {
        JQuickImportFieldMapping jQuickImportFieldMapping=new JQuickImportFieldMapping();
        if(null!=ctx.STRING()&&ctx.STRING().size()==1){
            jQuickImportFieldMapping.setFieldName(ctx.STRING().get(0).getText());
        }
        if(null!=ctx.STRING()&&ctx.STRING().size()==2){
            jQuickImportFieldMapping.setMappingFieldName(ctx.STRING().get(1).getText());
        }
        if(null!=ctx.functionCall()){
            Object result=visitFunctionCall(ctx.functionCall());
            jQuickImportFieldMapping.setFunctionCall(result);
        }
        if(null!=ctx.jsonPath()){
            Object result=visitJsonPath(ctx.jsonPath());
            jQuickImportFieldMapping.setJsonPath(result);
        }
        return jQuickImportFieldMapping;
    }

    @Override
    public Void visitTransformOption(JQuickExcelParser.TransformOptionContext ctx) {
        for (JQuickExcelParser.TransformRuleContext ruleCtx : ctx.transformRule()) {
             visitTransformRule(ruleCtx);
        }
    return null;
    }
    @Override
    public Void visitTransformRule(JQuickExcelParser.TransformRuleContext ctx) {
        if (ctx.STRING() != null) {
            String filed=ctx.STRING().getText();
        }
        return null;
    }

}
