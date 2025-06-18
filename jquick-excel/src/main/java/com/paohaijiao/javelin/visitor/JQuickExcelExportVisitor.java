/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */
package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.handler.JExcelProcessor;
import com.paohaijiao.javelin.model.JExcelExportModel;
import com.paohaijiao.javelin.parser.JQuickExcelParser;
import com.paohaijiao.javelin.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName com.paohaijiao.javelin.visitor
 *
 * @author Martin
 * @version 1.0.0
 * @className JQuickExcelExportVisitor
 * @date 2025/6/18
 * @description
 */
public class JQuickExcelExportVisitor extends JFormatSpecVisitor {
    private final JExcelProcessor excelProcessor;

    private final List<Map<String, String>> data;

    private JExcelExportModel config = new JExcelExportModel();

    public JQuickExcelExportVisitor(List<Map<String, String>> data) {
        this.excelProcessor = new JExcelProcessor();
        this.data = data;
    }

    @Override
    public JExcelExportModel visitExportConfig(JQuickExcelParser.ExportConfigContext ctx) {
        String source = ctx.source().getText();
        config.setSource(source);
        String outputFile = ctx.STRING().getText().replaceAll("\"", "");
        config.setOutputFile(outputFile);
        if (ctx.exportOption() != null) {
            for (JQuickExcelParser.ExportOptionContext option : ctx.exportOption()) {
                visit(option);
            }
        }
//        try {
//            excelProcessor.exportData(data, outputFile, config);
//        } catch (IOException e) {
//            throw new RuntimeException("导出Excel失败: " + outputFile, e);
//        }
        return config;
    }

    @Override
    public Void visitSheetOption(JQuickExcelParser.SheetOptionContext ctx) {
        Object sheetValue = ctx.STRING() != null ? ctx.STRING().getText().replaceAll("\"", "") :
                Integer.parseInt(ctx.NUMBER().getText());
        config.setSheet(sheetValue);
        return null;
    }

    @Override
    public Void visitHeaderOption(JQuickExcelParser.HeaderOptionContext ctx) {
        config.setHeader(ctx.getText().equalsIgnoreCase("YES"));
        return null;
    }

    @Override
    public Void visitRangeOption(JQuickExcelParser.RangeOptionContext ctx) {
        String range= StringUtils.trim(ctx.STRING().getText());
        config.setRange(range);
        return null;
    }

    @Override
    public Void visitFormatOption(JQuickExcelParser.FormatOptionContext ctx) {
        Map<String, String> formats = new HashMap<>();
        for (JQuickExcelParser.CellFormatContext format : ctx.cellFormat()) {
            String field = format.STRING().getText().replaceAll("\"", "");
            String formatSpec = format.formatSpec().getText();
            formats.put(field, formatSpec);
        }
        config.setFormat( formats);
        return null;
    }

    @Override
    public Void visitFormulaOption(JQuickExcelParser.FormulaOptionContext ctx) {
        Map<String, String> formulas = new HashMap<>();
        for (JQuickExcelParser.ExcelFormulaContext formula : ctx.excelFormula()) {
            String cell = formula.STRING(0).getText().replaceAll("\"", "");
            String formulaText = formula.STRING(1).getText().replaceAll("\"", "");
            formulas.put(cell, formulaText);
        }
        config.setFormulas( formulas);
        return null;
    }
}
