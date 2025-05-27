// Generated from D:/idea/jthornruleGrammer/QuickLang/JThornRuleQuickLang.g4 by ANTLR 4.13.2
package org.paohaijiao.jstark.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JThornRuleQuickLangParser}.
 */
public interface JThornRuleQuickLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(JThornRuleQuickLangParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(JThornRuleQuickLangParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(JThornRuleQuickLangParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(JThornRuleQuickLangParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(JThornRuleQuickLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(JThornRuleQuickLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(JThornRuleQuickLangParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(JThornRuleQuickLangParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterCalculation(JThornRuleQuickLangParser.CalculationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitCalculation(JThornRuleQuickLangParser.CalculationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 */
	void enterParenIndex(JThornRuleQuickLangParser.ParenIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 */
	void exitParenIndex(JThornRuleQuickLangParser.ParenIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mutiLineIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 */
	void enterMutiLineIndex(JThornRuleQuickLangParser.MutiLineIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mutiLineIndex}
	 * labeled alternative in {@link JThornRuleQuickLangParser#index}.
	 * @param ctx the parse tree
	 */
	void exitMutiLineIndex(JThornRuleQuickLangParser.MutiLineIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#mutiLine}.
	 * @param ctx the parse tree
	 */
	void enterMutiLine(JThornRuleQuickLangParser.MutiLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#mutiLine}.
	 * @param ctx the parse tree
	 */
	void exitMutiLine(JThornRuleQuickLangParser.MutiLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#singleLine}.
	 * @param ctx the parse tree
	 */
	void enterSingleLine(JThornRuleQuickLangParser.SingleLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#singleLine}.
	 * @param ctx the parse tree
	 */
	void exitSingleLine(JThornRuleQuickLangParser.SingleLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(JThornRuleQuickLangParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(JThornRuleQuickLangParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(JThornRuleQuickLangParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(JThornRuleQuickLangParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(JThornRuleQuickLangParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(JThornRuleQuickLangParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(JThornRuleQuickLangParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(JThornRuleQuickLangParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(JThornRuleQuickLangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link JThornRuleQuickLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(JThornRuleQuickLangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(JThornRuleQuickLangParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(JThornRuleQuickLangParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#singgelBool}.
	 * @param ctx the parse tree
	 */
	void enterSinggelBool(JThornRuleQuickLangParser.SinggelBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#singgelBool}.
	 * @param ctx the parse tree
	 */
	void exitSinggelBool(JThornRuleQuickLangParser.SinggelBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(JThornRuleQuickLangParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(JThornRuleQuickLangParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#numberBool}.
	 * @param ctx the parse tree
	 */
	void enterNumberBool(JThornRuleQuickLangParser.NumberBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#numberBool}.
	 * @param ctx the parse tree
	 */
	void exitNumberBool(JThornRuleQuickLangParser.NumberBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#stringBool}.
	 * @param ctx the parse tree
	 */
	void enterStringBool(JThornRuleQuickLangParser.StringBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#stringBool}.
	 * @param ctx the parse tree
	 */
	void exitStringBool(JThornRuleQuickLangParser.StringBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#dateBool}.
	 * @param ctx the parse tree
	 */
	void enterDateBool(JThornRuleQuickLangParser.DateBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#dateBool}.
	 * @param ctx the parse tree
	 */
	void exitDateBool(JThornRuleQuickLangParser.DateBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(JThornRuleQuickLangParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(JThornRuleQuickLangParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(JThornRuleQuickLangParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(JThornRuleQuickLangParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(JThornRuleQuickLangParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(JThornRuleQuickLangParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(JThornRuleQuickLangParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(JThornRuleQuickLangParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickLangParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(JThornRuleQuickLangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickLangParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(JThornRuleQuickLangParser.IdContext ctx);
}