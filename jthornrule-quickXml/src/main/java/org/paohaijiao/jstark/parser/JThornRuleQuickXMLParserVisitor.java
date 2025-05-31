package org.paohaijiao.jstark.parser;// Generated from D:/idea/jthornruleGrammer/xml/JThornRuleQuickXMLParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JThornRuleQuickXMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JThornRuleQuickXMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(JThornRuleQuickXMLParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog(JThornRuleQuickXMLParser.PrologContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(JThornRuleQuickXMLParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(JThornRuleQuickXMLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(JThornRuleQuickXMLParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(JThornRuleQuickXMLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChardata(JThornRuleQuickXMLParser.ChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMisc(JThornRuleQuickXMLParser.MiscContext ctx);
}