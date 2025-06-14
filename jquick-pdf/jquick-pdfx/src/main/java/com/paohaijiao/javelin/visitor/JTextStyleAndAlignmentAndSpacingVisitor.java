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

import com.paohaijiao.javelin.enums.JAlign;
import com.paohaijiao.javelin.enums.JUnit;
import com.paohaijiao.javelin.model.JColorModel;
import com.paohaijiao.javelin.model.JNumberUnitModel;
import com.paohaijiao.javelin.model.textStyle.JTextStyleFont;
import com.paohaijiao.javelin.parser.JQuickPDFParser;

import java.math.BigDecimal;

/**
 * packageName com.paohaijiao.javelin.visitor
 *
 * @author Martin
 * @version 1.0.0
 * @className JTextStyleAndAlignmentAndSpacingVisitor
 * @date 2025/6/14
 * @description
 */
public class JTextStyleAndAlignmentAndSpacingVisitor extends JPdfXLayOutVisitor{
    @Override
    public JTextStyleFont visitTextStylefont(JQuickPDFParser.TextStylefontContext ctx) {
        String font=visitString(ctx.string());
        JTextStyleFont jTextStyleFont=new JTextStyleFont();
        jTextStyleFont.setFontName(font);
        return jTextStyleFont;
    }
    @Override
    public JTextStyleFont visitTextStyleSize(JQuickPDFParser.TextStyleSizeContext ctx) {
        BigDecimal number=visitNumber(ctx.number());
        JUnit unit=visitUnit(ctx.unit());
        JNumberUnitModel numberUnitModel=new JNumberUnitModel();
        numberUnitModel.setNumber(number.intValue());
        numberUnitModel.setUnit(unit);
        JTextStyleFont jTextStyleFont=new JTextStyleFont();
        jTextStyleFont.setNumberUnit(numberUnitModel);
        return jTextStyleFont;
    }
    @Override
    public JColorModel visitTextStyleColor(JQuickPDFParser.TextStyleColorContext ctx) {
        String color=visitColor(ctx.color());
        JColorModel jColorModel=new JColorModel();
        jColorModel.setColor(color);
        return jColorModel;
    }
    @Override
    public String visitTextStyleBold(JQuickPDFParser.TextStyleBoldContext ctx) {

        return "bold";
    }
    @Override
    public String visitTextStyleItalic(JQuickPDFParser.TextStyleItalicContext ctx) {
        return "italic";
    }
    @Override
    public String visitTextStyleUnderline(JQuickPDFParser.TextStyleUnderlineContext ctx) {
        return "underline";
    }
    @Override
    public String visitTextStyleAlign(JQuickPDFParser.TextStyleAlignContext ctx) {
        return ctx.ID().getText();
    }
    @Override
    public JAlign visitAlignment(JQuickPDFParser.AlignmentContext ctx) {
        return visitAlignmentLocation(ctx.alignmentLocation());
    }

    @Override
    public JAlign visitAlignmentLocation(JQuickPDFParser.AlignmentLocationContext ctx) {
        String text=ctx.getText();
        return JAlign.codeOf(text);
    }







}
