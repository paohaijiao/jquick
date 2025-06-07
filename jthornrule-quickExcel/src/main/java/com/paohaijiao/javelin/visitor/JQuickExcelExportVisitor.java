import com.paohaijiao.javelin.parser.JQuickExcelParser;

import java.util.HashMap;
import java.util.Map;

//package com.paohaijiao.javelin.visitor;
//
//import com.paohaijiao.javelin.parser.JQuickExcelParser;
//
//import java.util.*;
//
//public class JQuickExcelExportVisitor<Object> extends JQuickExcelCommonVisitor<Object> {
//    @Override
//    public Object visitSheetOption(JQuickExcelParser.SheetOptionContext ctx) {
//        Map<String, String> option = new LinkedHashMap<>();
//        option.put("optionType", "sheet");
//
//        // 处理工作表名或索引
//        if (ctx.STRING() != null) {
//            option.put("value", removeQuotes(ctx.STRING().getText()));
//            option.put("valueType", "name");
//        } else if (ctx.INTEGER() != null) {
//            try {
//                option.put("value", Integer.parseInt(ctx.INTEGER().getText()));
//                option.put("valueType", "index");
//            } catch (NumberFormatException e) {
//              e.printStackTrace();
//            }
//        }
//
//        option.put("sourcePosition", getSourcePosition(ctx));
//        return option;
//    }
//    @Override
//    public Object visitHeaderOption(JQuickExcelParser.HeaderOptionContext ctx) {
//        Map<String, Object> option = new LinkedHashMap<>();
//        option.put("optionType", "header");
//
//        // 处理三种形式的表头设置
//        if (ctx.INTEGER() != null) {
//            try {
//                option.put("value", Integer.parseInt(ctx.INTEGER().getText()));
//                option.put("valueType", "rowIndex");
//            } catch (NumberFormatException e) {
//                throw new ParsingException("Invalid header row index: " + ctx.INTEGER().getText(),
//                        ctx.INTEGER().getSymbol());
//            }
//        } else {
//            option.put("value", ctx.getText().equalsIgnoreCase("YES"));
//            option.put("valueType", "boolean");
//        }
//
//        option.put("sourcePosition", getSourcePosition(ctx));
//        return option;
//    }
//    @Override
//    public Object visitFormatOption(JQuickExcelParser.FormatOptionContext ctx) {
//        Map<String, Object> option = new LinkedHashMap<>();
//        option.put("optionType", "format");
//
//        // 解析所有单元格格式设置
//        Map<String, Object> formats = new LinkedHashMap<>();
//        for (JQuickExcelParser.CellFormatContext formatCtx : ctx.cellFormat()) {
//            String cellRef = removeQuotes(formatCtx.STRING().getText());
//            String formatSpec = formatCtx.formatSpec().getText();
//
//            // 解析格式规范
//            Map<String, Object> formatInfo = parseFormatSpec(formatSpec);
//            formats.put(cellRef, formatInfo);
//        }
//
//        option.put("value", formats);
//        option.put("sourcePosition", getSourcePosition(ctx));
//        return option;
//    }
//    @Override
//    public Object visitRangeOption(JQuickExcelParser.RangeOptionContext ctx) {
//        Map<String, Object> option = new LinkedHashMap<>();
//        option.put("optionType", "range");
//
//        String range = removeQuotes(ctx.STRING().getText());
//        option.put("value", range);
//
//        // 验证范围格式
//        if (!range.matches("^[A-Z]+\\d+:[A-Z]+\\d+$")) {
//            throw new ParsingException("Invalid range format: " + range,
//                    ctx.STRING().getSymbol());
//        }
//
//        option.put("sourcePosition", getSourcePosition(ctx));
//        return option;
//    }
//    @Override
//    public Object visitFormulaOption(JQuickExcelParser.FormulaOptionContext ctx) {
//        Map<String, String> option = new LinkedHashMap<>();
//        option.put("optionType", "formula");
//        // 解析所有公式设置
//        Map<String, String> formulas = new LinkedHashMap<>();
//        for (JQuickExcelParser.ExcelFormulaContext formulaCtx : ctx.excelFormula()) {
//            String cellRef = removeQuotes(formulaCtx.STRING(0).getText());
//            String formula = removeQuotes(formulaCtx.STRING(1).getText());
//
//            // 验证公式基本格式
//            if (formula.startsWith("=")) {
//                formula = formula.substring(1);
//            }
//
//            formulas.put(cellRef, formula);
//        }
//
//        option.put("value", formulas);
//        option.put("sourcePosition", getSourcePosition(ctx));
//        return option;
//    }
//public Object visitDestination(JQuickExcelParser.DestinationContext ctx) {
//    Map<String, String> result = new HashMap<>();
//    if (ctx.identifier() != null) {
//        result.put("type", "identifier");
//        result.put("value", ctx.identifier().getText());
//    }
//    else if (ctx.jsonPath() != null) {
//        result.put("type", "jsonPath");
//        result.put("value", ctx.jsonPath().getText());
//    }
//    else if (ctx.apiCall() != null) {
//        Map<String, String> apiCallResult = (Map<String, String>) visit(ctx.apiCall());
//        result.put("type", "apiCall");
//        result.put("value", apiCallResult);
//    }
//    return result;
//}
