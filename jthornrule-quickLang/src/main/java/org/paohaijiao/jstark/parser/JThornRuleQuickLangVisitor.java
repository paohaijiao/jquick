// Generated from D:/idea/jthornruleGrammer/QuickLang/JThornRuleQuickLang.g4 by ANTLR 4.13.2
package org.paohaijiao.jstark.parser;
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
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculation(JThornRuleQuickLangParser.CalculationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenIndex(JThornRuleQuickLangParser.ParenIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mutiLineIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutiLineIndex(JThornRuleQuickLangParser.MutiLineIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#mutiLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutiLine(JThornRuleQuickLangParser.MutiLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JThornRuleQuickLangParser#singleLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleLine(JThornRuleQuickLangParser.SingleLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(JThornRuleQuickLangParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(JThornRuleQuickLangParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(JThornRuleQuickLangParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(JThornRuleQuickLangParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(JThornRuleQuickLangParser.ParenExprContext ctx);
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