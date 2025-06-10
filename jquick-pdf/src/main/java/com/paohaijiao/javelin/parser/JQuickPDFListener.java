// Generated from D:/idea/jthornruleGrammer/pdf/JQuickPDF.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JQuickPDFParser}.
 */
public interface JQuickPDFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(JQuickPDFParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(JQuickPDFParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(JQuickPDFParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(JQuickPDFParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code a4}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void enterA4(JQuickPDFParser.A4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code a4}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void exitA4(JQuickPDFParser.A4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code letter}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void enterLetter(JQuickPDFParser.LetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letter}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void exitLetter(JQuickPDFParser.LetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code custom}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void enterCustom(JQuickPDFParser.CustomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 */
	void exitCustom(JQuickPDFParser.CustomContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#margins}.
	 * @param ctx the parse tree
	 */
	void enterMargins(JQuickPDFParser.MarginsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#margins}.
	 * @param ctx the parse tree
	 */
	void exitMargins(JQuickPDFParser.MarginsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(JQuickPDFParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(JQuickPDFParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(JQuickPDFParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(JQuickPDFParser.ParagraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#heading}.
	 * @param ctx the parse tree
	 */
	void enterHeading(JQuickPDFParser.HeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#heading}.
	 * @param ctx the parse tree
	 */
	void exitHeading(JQuickPDFParser.HeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(JQuickPDFParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(JQuickPDFParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#list_item}.
	 * @param ctx the parse tree
	 */
	void enterList_item(JQuickPDFParser.List_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#list_item}.
	 * @param ctx the parse tree
	 */
	void exitList_item(JQuickPDFParser.List_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(JQuickPDFParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(JQuickPDFParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#table_row}.
	 * @param ctx the parse tree
	 */
	void enterTable_row(JQuickPDFParser.Table_rowContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#table_row}.
	 * @param ctx the parse tree
	 */
	void exitTable_row(JQuickPDFParser.Table_rowContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#table_cell}.
	 * @param ctx the parse tree
	 */
	void enterTable_cell(JQuickPDFParser.Table_cellContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#table_cell}.
	 * @param ctx the parse tree
	 */
	void exitTable_cell(JQuickPDFParser.Table_cellContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#image}.
	 * @param ctx the parse tree
	 */
	void enterImage(JQuickPDFParser.ImageContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#image}.
	 * @param ctx the parse tree
	 */
	void exitImage(JQuickPDFParser.ImageContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#svg}.
	 * @param ctx the parse tree
	 */
	void enterSvg(JQuickPDFParser.SvgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#svg}.
	 * @param ctx the parse tree
	 */
	void exitSvg(JQuickPDFParser.SvgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(JQuickPDFParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(JQuickPDFParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(JQuickPDFParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(JQuickPDFParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#paragraph_style}.
	 * @param ctx the parse tree
	 */
	void enterParagraph_style(JQuickPDFParser.Paragraph_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#paragraph_style}.
	 * @param ctx the parse tree
	 */
	void exitParagraph_style(JQuickPDFParser.Paragraph_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#text_style}.
	 * @param ctx the parse tree
	 */
	void enterText_style(JQuickPDFParser.Text_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#text_style}.
	 * @param ctx the parse tree
	 */
	void exitText_style(JQuickPDFParser.Text_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#alignment}.
	 * @param ctx the parse tree
	 */
	void enterAlignment(JQuickPDFParser.AlignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#alignment}.
	 * @param ctx the parse tree
	 */
	void exitAlignment(JQuickPDFParser.AlignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#spacing}.
	 * @param ctx the parse tree
	 */
	void enterSpacing(JQuickPDFParser.SpacingContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#spacing}.
	 * @param ctx the parse tree
	 */
	void exitSpacing(JQuickPDFParser.SpacingContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#image_style}.
	 * @param ctx the parse tree
	 */
	void enterImage_style(JQuickPDFParser.Image_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#image_style}.
	 * @param ctx the parse tree
	 */
	void exitImage_style(JQuickPDFParser.Image_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#svg_style}.
	 * @param ctx the parse tree
	 */
	void enterSvg_style(JQuickPDFParser.Svg_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#svg_style}.
	 * @param ctx the parse tree
	 */
	void exitSvg_style(JQuickPDFParser.Svg_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#div_style}.
	 * @param ctx the parse tree
	 */
	void enterDiv_style(JQuickPDFParser.Div_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#div_style}.
	 * @param ctx the parse tree
	 */
	void exitDiv_style(JQuickPDFParser.Div_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(JQuickPDFParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(JQuickPDFParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#background}.
	 * @param ctx the parse tree
	 */
	void enterBackground(JQuickPDFParser.BackgroundContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#background}.
	 * @param ctx the parse tree
	 */
	void exitBackground(JQuickPDFParser.BackgroundContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#border}.
	 * @param ctx the parse tree
	 */
	void enterBorder(JQuickPDFParser.BorderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#border}.
	 * @param ctx the parse tree
	 */
	void exitBorder(JQuickPDFParser.BorderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#opacity}.
	 * @param ctx the parse tree
	 */
	void enterOpacity(JQuickPDFParser.OpacityContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#opacity}.
	 * @param ctx the parse tree
	 */
	void exitOpacity(JQuickPDFParser.OpacityContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#scale}.
	 * @param ctx the parse tree
	 */
	void enterScale(JQuickPDFParser.ScaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#scale}.
	 * @param ctx the parse tree
	 */
	void exitScale(JQuickPDFParser.ScaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#float}.
	 * @param ctx the parse tree
	 */
	void enterFloat(JQuickPDFParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#float}.
	 * @param ctx the parse tree
	 */
	void exitFloat(JQuickPDFParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(JQuickPDFParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(JQuickPDFParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickPDFParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(JQuickPDFParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickPDFParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(JQuickPDFParser.UnitContext ctx);
}