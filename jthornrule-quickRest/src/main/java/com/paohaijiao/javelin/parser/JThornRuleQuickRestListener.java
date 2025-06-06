// Generated from D:/idea/jthornruleGrammer/QuickRest/JThornRuleQuickRest.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JThornRuleQuickRestParser}.
 */
public interface JThornRuleQuickRestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#curlCommand}.
	 * @param ctx the parse tree
	 */
	void enterCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#curlCommand}.
	 * @param ctx the parse tree
	 */
	void exitCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(JThornRuleQuickRestParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(JThornRuleQuickRestParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#requestMethod}.
	 * @param ctx the parse tree
	 */
	void enterRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#requestMethod}.
	 * @param ctx the parse tree
	 */
	void exitRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#headerOption}.
	 * @param ctx the parse tree
	 */
	void enterHeaderOption(JThornRuleQuickRestParser.HeaderOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#headerOption}.
	 * @param ctx the parse tree
	 */
	void exitHeaderOption(JThornRuleQuickRestParser.HeaderOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#proxryOption}.
	 * @param ctx the parse tree
	 */
	void enterProxryOption(JThornRuleQuickRestParser.ProxryOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#proxryOption}.
	 * @param ctx the parse tree
	 */
	void exitProxryOption(JThornRuleQuickRestParser.ProxryOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#socketOption}.
	 * @param ctx the parse tree
	 */
	void enterSocketOption(JThornRuleQuickRestParser.SocketOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#socketOption}.
	 * @param ctx the parse tree
	 */
	void exitSocketOption(JThornRuleQuickRestParser.SocketOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#http2Option}.
	 * @param ctx the parse tree
	 */
	void enterHttp2Option(JThornRuleQuickRestParser.Http2OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#http2Option}.
	 * @param ctx the parse tree
	 */
	void exitHttp2Option(JThornRuleQuickRestParser.Http2OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#ignoreOption}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreOption(JThornRuleQuickRestParser.IgnoreOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#ignoreOption}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreOption(JThornRuleQuickRestParser.IgnoreOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#dataOption}.
	 * @param ctx the parse tree
	 */
	void enterDataOption(JThornRuleQuickRestParser.DataOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#dataOption}.
	 * @param ctx the parse tree
	 */
	void exitDataOption(JThornRuleQuickRestParser.DataOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#dataUrlEncodeOption}.
	 * @param ctx the parse tree
	 */
	void enterDataUrlEncodeOption(JThornRuleQuickRestParser.DataUrlEncodeOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#dataUrlEncodeOption}.
	 * @param ctx the parse tree
	 */
	void exitDataUrlEncodeOption(JThornRuleQuickRestParser.DataUrlEncodeOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#emptyData}.
	 * @param ctx the parse tree
	 */
	void enterEmptyData(JThornRuleQuickRestParser.EmptyDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#emptyData}.
	 * @param ctx the parse tree
	 */
	void exitEmptyData(JThornRuleQuickRestParser.EmptyDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#formData}.
	 * @param ctx the parse tree
	 */
	void enterFormData(JThornRuleQuickRestParser.FormDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#formData}.
	 * @param ctx the parse tree
	 */
	void exitFormData(JThornRuleQuickRestParser.FormDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#userOption}.
	 * @param ctx the parse tree
	 */
	void enterUserOption(JThornRuleQuickRestParser.UserOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#userOption}.
	 * @param ctx the parse tree
	 */
	void exitUserOption(JThornRuleQuickRestParser.UserOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#locationOption}.
	 * @param ctx the parse tree
	 */
	void enterLocationOption(JThornRuleQuickRestParser.LocationOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#locationOption}.
	 * @param ctx the parse tree
	 */
	void exitLocationOption(JThornRuleQuickRestParser.LocationOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#loption}.
	 * @param ctx the parse tree
	 */
	void enterLoption(JThornRuleQuickRestParser.LoptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#loption}.
	 * @param ctx the parse tree
	 */
	void exitLoption(JThornRuleQuickRestParser.LoptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#otherOption}.
	 * @param ctx the parse tree
	 */
	void enterOtherOption(JThornRuleQuickRestParser.OtherOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#otherOption}.
	 * @param ctx the parse tree
	 */
	void exitOtherOption(JThornRuleQuickRestParser.OtherOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#downloadOption}.
	 * @param ctx the parse tree
	 */
	void enterDownloadOption(JThornRuleQuickRestParser.DownloadOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#downloadOption}.
	 * @param ctx the parse tree
	 */
	void exitDownloadOption(JThornRuleQuickRestParser.DownloadOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#uploadOption}.
	 * @param ctx the parse tree
	 */
	void enterUploadOption(JThornRuleQuickRestParser.UploadOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#uploadOption}.
	 * @param ctx the parse tree
	 */
	void exitUploadOption(JThornRuleQuickRestParser.UploadOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JThornRuleQuickRestParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(JThornRuleQuickRestParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link JThornRuleQuickRestParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(JThornRuleQuickRestParser.UrlContext ctx);
}