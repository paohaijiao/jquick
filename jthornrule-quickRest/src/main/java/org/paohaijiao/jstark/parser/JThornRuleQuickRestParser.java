// Generated from D:/idea/jthornruleGrammer/QuickRest/JThornRuleQuickRest.g4 by ANTLR 4.13.2
package org.paohaijiao.jstark.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JThornRuleQuickRestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, HTTP_METHOD=22, STRING=23, STRING_EMPTY=24, 
		URL=25, WS=26, LINE_CONTINUATION=27, UNKNOWN=28;
	public static final int
		RULE_curlCommand = 0, RULE_option = 1, RULE_requestMethod = 2, RULE_headerOption = 3, 
		RULE_dataOption = 4, RULE_dataUrlEncodeOption = 5, RULE_emptyData = 6, 
		RULE_formData = 7, RULE_userOption = 8, RULE_locationOption = 9, RULE_otherOption = 10, 
		RULE_url = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"curlCommand", "option", "requestMethod", "headerOption", "dataOption", 
			"dataUrlEncodeOption", "emptyData", "formData", "userOption", "locationOption", 
			"otherOption", "url"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'curl'", "'-X'", "'--request'", "'-H'", "'--header'", "'-d'", 
			"'--data'", "'--data-ascii'", "'--data-binary'", "'--data-raw'", "'--data-urlencode'", 
			"'-u'", "'--user'", "'-L'", "'--location'", "'-v'", "'--verbose'", "'-s'", 
			"'--silent'", "'-k'", "'--insecure'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "HTTP_METHOD", 
			"STRING", "STRING_EMPTY", "URL", "WS", "LINE_CONTINUATION", "UNKNOWN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JThornRuleQuickRest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JThornRuleQuickRestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CurlCommandContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<UrlContext> url() {
			return getRuleContexts(UrlContext.class);
		}
		public UrlContext url(int i) {
			return getRuleContext(UrlContext.class,i);
		}
		public CurlCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curlCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterCurlCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitCurlCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitCurlCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurlCommandContext curlCommand() throws RecognitionException {
		CurlCommandContext _localctx = new CurlCommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_curlCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(27);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(25);
					option();
					}
					break;
				case STRING:
				case URL:
					{
					setState(26);
					url();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 46137340L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionContext extends ParserRuleContext {
		public RequestMethodContext requestMethod() {
			return getRuleContext(RequestMethodContext.class,0);
		}
		public HeaderOptionContext headerOption() {
			return getRuleContext(HeaderOptionContext.class,0);
		}
		public DataOptionContext dataOption() {
			return getRuleContext(DataOptionContext.class,0);
		}
		public DataUrlEncodeOptionContext dataUrlEncodeOption() {
			return getRuleContext(DataUrlEncodeOptionContext.class,0);
		}
		public UserOptionContext userOption() {
			return getRuleContext(UserOptionContext.class,0);
		}
		public LocationOptionContext locationOption() {
			return getRuleContext(LocationOptionContext.class,0);
		}
		public OtherOptionContext otherOption() {
			return getRuleContext(OtherOptionContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_option);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				requestMethod();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				headerOption();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				dataOption();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				dataUrlEncodeOption();
				}
				break;
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(35);
				userOption();
				}
				break;
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(36);
				locationOption();
				}
				break;
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 7);
				{
				setState(37);
				otherOption();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequestMethodContext extends ParserRuleContext {
		public Token method;
		public TerminalNode HTTP_METHOD() { return getToken(JThornRuleQuickRestParser.HTTP_METHOD, 0); }
		public RequestMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterRequestMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitRequestMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitRequestMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequestMethodContext requestMethod() throws RecognitionException {
		RequestMethodContext _localctx = new RequestMethodContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requestMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(41);
			((RequestMethodContext)_localctx).method = match(HTTP_METHOD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderOptionContext extends ParserRuleContext {
		public Token headerValue;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public HeaderOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterHeaderOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitHeaderOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitHeaderOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderOptionContext headerOption() throws RecognitionException {
		HeaderOptionContext _localctx = new HeaderOptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_headerOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(44);
			((HeaderOptionContext)_localctx).headerValue = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataOptionContext extends ParserRuleContext {
		public Token dataValue;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public DataOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterDataOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitDataOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitDataOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataOptionContext dataOption() throws RecognitionException {
		DataOptionContext _localctx = new DataOptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1984L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(47);
			((DataOptionContext)_localctx).dataValue = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataUrlEncodeOptionContext extends ParserRuleContext {
		public EmptyDataContext emptyData() {
			return getRuleContext(EmptyDataContext.class,0);
		}
		public FormDataContext formData() {
			return getRuleContext(FormDataContext.class,0);
		}
		public DataUrlEncodeOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataUrlEncodeOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterDataUrlEncodeOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitDataUrlEncodeOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitDataUrlEncodeOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataUrlEncodeOptionContext dataUrlEncodeOption() throws RecognitionException {
		DataUrlEncodeOptionContext _localctx = new DataUrlEncodeOptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataUrlEncodeOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__10);
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_EMPTY:
				{
				setState(50);
				emptyData();
				}
				break;
			case STRING:
				{
				setState(51);
				formData();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyDataContext extends ParserRuleContext {
		public TerminalNode STRING_EMPTY() { return getToken(JThornRuleQuickRestParser.STRING_EMPTY, 0); }
		public EmptyDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterEmptyData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitEmptyData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitEmptyData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyDataContext emptyData() throws RecognitionException {
		EmptyDataContext _localctx = new EmptyDataContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_emptyData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(STRING_EMPTY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormDataContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public FormDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterFormData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitFormData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitFormData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormDataContext formData() throws RecognitionException {
		FormDataContext _localctx = new FormDataContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserOptionContext extends ParserRuleContext {
		public Token userValue;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public UserOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterUserOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitUserOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitUserOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserOptionContext userOption() throws RecognitionException {
		UserOptionContext _localctx = new UserOptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_userOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(59);
			((UserOptionContext)_localctx).userValue = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationOptionContext extends ParserRuleContext {
		public LocationOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterLocationOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitLocationOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitLocationOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationOptionContext locationOption() throws RecognitionException {
		LocationOptionContext _localctx = new LocationOptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_locationOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OtherOptionContext extends ParserRuleContext {
		public OtherOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterOtherOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitOtherOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitOtherOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherOptionContext otherOption() throws RecognitionException {
		OtherOptionContext _localctx = new OtherOptionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_otherOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4128768L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UrlContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public TerminalNode URL() { return getToken(JThornRuleQuickRestParser.URL, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==URL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001cD\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f"+
		"\u0000\u001d\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00055\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0007\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0005\u0001\u0000"+
		"\u0006\n\u0001\u0000\f\r\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0015"+
		"\u0002\u0000\u0017\u0017\u0019\u0019@\u0000\u0018\u0001\u0000\u0000\u0000"+
		"\u0002&\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000\u0000\u0006+"+
		"\u0001\u0000\u0000\u0000\b.\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000"+
		"\u0000\f6\u0001\u0000\u0000\u0000\u000e8\u0001\u0000\u0000\u0000\u0010"+
		":\u0001\u0000\u0000\u0000\u0012=\u0001\u0000\u0000\u0000\u0014?\u0001"+
		"\u0000\u0000\u0000\u0016A\u0001\u0000\u0000\u0000\u0018\u001b\u0005\u0001"+
		"\u0000\u0000\u0019\u001c\u0003\u0002\u0001\u0000\u001a\u001c\u0003\u0016"+
		"\u000b\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001a\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f\'\u0003\u0004\u0002\u0000 \'\u0003\u0006\u0003\u0000"+
		"!\'\u0003\b\u0004\u0000\"\'\u0003\n\u0005\u0000#\'\u0003\u0010\b\u0000"+
		"$\'\u0003\u0012\t\u0000%\'\u0003\u0014\n\u0000&\u001f\u0001\u0000\u0000"+
		"\u0000& \u0001\u0000\u0000\u0000&!\u0001\u0000\u0000\u0000&\"\u0001\u0000"+
		"\u0000\u0000&#\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0007\u0000\u0000"+
		"\u0000)*\u0005\u0016\u0000\u0000*\u0005\u0001\u0000\u0000\u0000+,\u0007"+
		"\u0001\u0000\u0000,-\u0005\u0017\u0000\u0000-\u0007\u0001\u0000\u0000"+
		"\u0000./\u0007\u0002\u0000\u0000/0\u0005\u0017\u0000\u00000\t\u0001\u0000"+
		"\u0000\u000014\u0005\u000b\u0000\u000025\u0003\f\u0006\u000035\u0003\u000e"+
		"\u0007\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u000b"+
		"\u0001\u0000\u0000\u000067\u0005\u0018\u0000\u00007\r\u0001\u0000\u0000"+
		"\u000089\u0005\u0017\u0000\u00009\u000f\u0001\u0000\u0000\u0000:;\u0007"+
		"\u0003\u0000\u0000;<\u0005\u0017\u0000\u0000<\u0011\u0001\u0000\u0000"+
		"\u0000=>\u0007\u0004\u0000\u0000>\u0013\u0001\u0000\u0000\u0000?@\u0007"+
		"\u0005\u0000\u0000@\u0015\u0001\u0000\u0000\u0000AB\u0007\u0006\u0000"+
		"\u0000B\u0017\u0001\u0000\u0000\u0000\u0004\u001b\u001d&4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}