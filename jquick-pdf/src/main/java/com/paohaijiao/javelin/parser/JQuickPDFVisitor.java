// Generated from D:/idea/jthornruleGrammer/pdf/JQuickPDF.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JQuickPDFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JQuickPDFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(JQuickPDFParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(JQuickPDFParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code a4}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA4(JQuickPDFParser.A4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code letter}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetter(JQuickPDFParser.LetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code custom}
	 * labeled alternative in {@link JQuickPDFParser#pageLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustom(JQuickPDFParser.CustomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#margins}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMargins(JQuickPDFParser.MarginsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(JQuickPDFParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#paragraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraph(JQuickPDFParser.ParagraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#heading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeading(JQuickPDFParser.HeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(JQuickPDFParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#list_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_item(JQuickPDFParser.List_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(JQuickPDFParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#table_row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_row(JQuickPDFParser.Table_rowContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#table_cell}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_cell(JQuickPDFParser.Table_cellContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#image}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage(JQuickPDFParser.ImageContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#svg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSvg(JQuickPDFParser.SvgContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(JQuickPDFParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(JQuickPDFParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#paragraph_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraph_style(JQuickPDFParser.Paragraph_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#text_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_style(JQuickPDFParser.Text_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#alignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlignment(JQuickPDFParser.AlignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#spacing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpacing(JQuickPDFParser.SpacingContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#image_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage_style(JQuickPDFParser.Image_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#svg_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSvg_style(JQuickPDFParser.Svg_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#div_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv_style(JQuickPDFParser.Div_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(JQuickPDFParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#background}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackground(JQuickPDFParser.BackgroundContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#border}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorder(JQuickPDFParser.BorderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#opacity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpacity(JQuickPDFParser.OpacityContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale(JQuickPDFParser.ScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#float}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(JQuickPDFParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(JQuickPDFParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickPDFParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(JQuickPDFParser.UnitContext ctx);
}