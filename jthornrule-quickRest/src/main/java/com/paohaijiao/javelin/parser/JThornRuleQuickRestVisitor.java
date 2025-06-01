// Generated from D:/idea/jthornruleGrammer/QuickRest/JThornRuleQuickRest.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JThornRuleQuickRestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JThornRuleQuickRestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#curlCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(JThornRuleQuickRestParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#requestMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#headerOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderOption(JThornRuleQuickRestParser.HeaderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#dataOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataOption(JThornRuleQuickRestParser.DataOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#dataUrlEncodeOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataUrlEncodeOption(JThornRuleQuickRestParser.DataUrlEncodeOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#emptyData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyData(JThornRuleQuickRestParser.EmptyDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#formData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormData(JThornRuleQuickRestParser.FormDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#userOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserOption(JThornRuleQuickRestParser.UserOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#locationOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationOption(JThornRuleQuickRestParser.LocationOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#otherOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherOption(JThornRuleQuickRestParser.OtherOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickRestParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(JThornRuleQuickRestParser.UrlContext ctx);
}