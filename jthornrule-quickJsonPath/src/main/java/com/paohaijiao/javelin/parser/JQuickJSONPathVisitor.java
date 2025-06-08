package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/JSONPath/JQuickJSONPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JQuickJSONPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JQuickJSONPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(JQuickJSONPathParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(JQuickJSONPathParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegment(JQuickJSONPathParser.SegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(JQuickJSONPathParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#filterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice(JQuickJSONPathParser.SliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#scriptExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptExpression(JQuickJSONPathParser.ScriptExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JQuickJSONPathParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(JQuickJSONPathParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#regexLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexLiteral(JQuickJSONPathParser.RegexLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(JQuickJSONPathParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JQuickJSONPathParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JQuickJSONPathParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickJSONPathParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JQuickJSONPathParser.NumberContext ctx);
}