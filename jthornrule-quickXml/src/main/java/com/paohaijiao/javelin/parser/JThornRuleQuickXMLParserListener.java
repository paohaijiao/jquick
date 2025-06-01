package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/xml/JThornRuleQuickXMLParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JThornRuleQuickXMLParser}.
 */
public interface JThornRuleQuickXMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(JThornRuleQuickXMLParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(JThornRuleQuickXMLParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(JThornRuleQuickXMLParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(JThornRuleQuickXMLParser.PrologContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(JThornRuleQuickXMLParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(JThornRuleQuickXMLParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(JThornRuleQuickXMLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(JThornRuleQuickXMLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(JThornRuleQuickXMLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(JThornRuleQuickXMLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(JThornRuleQuickXMLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(JThornRuleQuickXMLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterChardata(JThornRuleQuickXMLParser.ChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitChardata(JThornRuleQuickXMLParser.ChardataContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(JThornRuleQuickXMLParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(JThornRuleQuickXMLParser.MiscContext ctx);
}