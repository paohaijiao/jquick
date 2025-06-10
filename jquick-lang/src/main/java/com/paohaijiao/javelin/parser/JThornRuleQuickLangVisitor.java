// Generated from D:/idea/jthornruleGrammer/QuickLang/JThornRuleQuickLang.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JThornRuleQuickLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JThornRuleQuickLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(JThornRuleQuickLangParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(JThornRuleQuickLangParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(JThornRuleQuickLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#elseIfStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatment(JThornRuleQuickLangParser.ElseIfStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#elseAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseAction(JThornRuleQuickLangParser.ElseActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(JThornRuleQuickLangParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(JThornRuleQuickLangParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#singgelBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinggelBool(JThornRuleQuickLangParser.SinggelBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(JThornRuleQuickLangParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#numberBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBool(JThornRuleQuickLangParser.NumberBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#stringBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringBool(JThornRuleQuickLangParser.StringBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#dateBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateBool(JThornRuleQuickLangParser.DateBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JThornRuleQuickLangParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(JThornRuleQuickLangParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(JThornRuleQuickLangParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(JThornRuleQuickLangParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(JThornRuleQuickLangParser.IdContext ctx);
}