package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/JSONPath/JQuickJSONPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JQuickJSONPathParser}.
 */
public interface JQuickJSONPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(JQuickJSONPathParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(JQuickJSONPathParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(JQuickJSONPathParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(JQuickJSONPathParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(JQuickJSONPathParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(JQuickJSONPathParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(JQuickJSONPathParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(JQuickJSONPathParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterSlice(JQuickJSONPathParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitSlice(JQuickJSONPathParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#scriptExpression}.
	 * @param ctx the parse tree
	 */
	void enterScriptExpression(JQuickJSONPathParser.ScriptExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#scriptExpression}.
	 * @param ctx the parse tree
	 */
	void exitScriptExpression(JQuickJSONPathParser.ScriptExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JQuickJSONPathParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JQuickJSONPathParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(JQuickJSONPathParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(JQuickJSONPathParser.ValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#regexLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRegexLiteral(JQuickJSONPathParser.RegexLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#regexLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRegexLiteral(JQuickJSONPathParser.RegexLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(JQuickJSONPathParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(JQuickJSONPathParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JQuickJSONPathParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JQuickJSONPathParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JQuickJSONPathParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JQuickJSONPathParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickJSONPathParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(JQuickJSONPathParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickJSONPathParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(JQuickJSONPathParser.NumberContext ctx);
}