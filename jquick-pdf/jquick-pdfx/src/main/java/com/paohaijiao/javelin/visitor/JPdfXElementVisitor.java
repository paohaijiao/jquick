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
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.ListNumberingType;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.paohaijiao.javelin.parser.JQuickPDFParser;

import java.io.IOException;

/**
 * packageName com.paohaijiao.javelin.visitor
 *
 * @author Martin
 * @version 1.0.0
 * @className JPdfXCommonVisitor
 * @date 2025/6/14
 * @description
 */
public class JPdfXElementVisitor extends JPdfXLayOutVisitor {



    @Override
    public IElement  visitElement(JQuickPDFParser.ElementContext ctx) {
        if (ctx.paragraph() != null) {
            return visitParagraph(ctx.paragraph());
        } else if (ctx.heading() != null) {
            return visitHeading(ctx.heading());
        } else if (ctx.list() != null) {
            return visitList(ctx.list());
        } else if (ctx.table() != null) {
            return visitTable(ctx.table());
        } else if (ctx.image() != null) {
            return visitImage(ctx.image());
        } else if (ctx.svg() != null) {
            return visitSvg(ctx.svg());
        } else if (ctx.div() != null) {
            return visitDiv(ctx.div());
        } else if (ctx.template() != null) {
            return visitTemplate(ctx.template());
        }
        return null;
    }

    @Override
    public Paragraph visitParagraph(JQuickPDFParser.ParagraphContext ctx) {
        String text = ctx.string().getText().replaceAll("^\"|\"$", "");
        Paragraph paragraph = new Paragraph(text);
        if (ctx.paragraphStyle() != null) {
            visitParagraphStyle(ctx.paragraphStyle());
        }
        //todo
        return paragraph;
    }
    @Override
    public Void visitParagraphStyle(JQuickPDFParser.ParagraphStyleContext ctx) {
        for (JQuickPDFParser.ParagraphStyleTypeContext styleCtx : ctx.paragraphStyleType()) {
            if (styleCtx.textStyle() != null) {
                visit(styleCtx.textStyle());
            } else if (styleCtx.alignment() != null) {
                visitAlignment(styleCtx.alignment());
            } else if (styleCtx.spacing() != null) {
                visitSpacing(styleCtx.spacing());
            }
        }
        return null;
    }

    @Override
    public Paragraph  visitHeading(JQuickPDFParser.HeadingContext ctx) {
        String level = ctx.getChild(1).getText();
        String text = ctx.string().getText().replaceAll("\"", "");
        Paragraph heading = new Paragraph(text);
        switch (level) {
            case "h1": heading.setFontSize(24); break;
            case "h2": heading.setFontSize(22); break;
            case "h3": heading.setFontSize(20); break;
            case "h4": heading.setFontSize(18); break;
            case "h5": heading.setFontSize(16); break;
            case "h6": heading.setFontSize(14); break;
        }

        return heading;
    }

    @Override
    public Table visitTable(JQuickPDFParser.TableContext ctx) {
        int colNum = 1;
        if(ctx.number() != null) {
            colNum=visitNumber(ctx.number()).intValue();
        }
        Table table = new Table(colNum);

        for (JQuickPDFParser.TableRowContext rowCtx : ctx.tableRow()) {
            for (JQuickPDFParser.TableCellContext cellCtx : rowCtx.tableCell()) {
                Cell cell = new Cell();

                for (JQuickPDFParser.ElementContext elementCtx : cellCtx.element()) {
                    IElement element = visitElement(elementCtx);
                    if (element instanceof BlockElement) {
                        cell.add((BlockElement) element);
                    }
                }

                table.addCell(cell);
            }
        }

        return table;
    }

    @Override
    public Image visitImage(JQuickPDFParser.ImageContext ctx) {

        return null;
    }
    @Override
    public Image visitSvg(JQuickPDFParser.SvgContext ctx) {

    }

    @Override
    public IElement visitDiv(JQuickPDFParser.DivContext ctx) {
        Div div = new Div();
        if (ctx.divStyle() != null) {

        }
        for (JQuickPDFParser.ElementContext elementCtx : ctx.element()) {
            IElement element = visitElement(elementCtx);
            if (element instanceof BlockElement) {
                div.add((BlockElement) element);
            }
        }

        return div;
    }

    @Override
    public IElement visitTemplate(JQuickPDFParser.TemplateContext ctx) {
        Div templateContent = new Div();
        for (JQuickPDFParser.ElementContext elementCtx : ctx.element()) {
            IElement element = visitElement(elementCtx);
            if (element instanceof BlockElement) {
                templateContent.add((BlockElement) element);
            }
        }
        if (ctx.ID(1) != null) {
        }

        return templateContent;
    }
}
