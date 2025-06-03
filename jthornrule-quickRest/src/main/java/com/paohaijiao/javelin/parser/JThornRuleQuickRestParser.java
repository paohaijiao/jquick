// Generated from D:/idea/jthornruleGrammer/QuickRest/JThornRuleQuickRest.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, HTTP_METHOD=29, STRING=30, WS=31, 
		LINE_CONTINUATION=32, UNKNOWN=33, STRING_EMPTY=34;
	public static final int
		RULE_curlCommand = 0, RULE_option = 1, RULE_requestMethod = 2, RULE_headerOption = 3, 
		RULE_proxryOption = 4, RULE_socketOption = 5, RULE_http2Option = 6, RULE_dataOption = 7, 
		RULE_dataUrlEncodeOption = 8, RULE_emptyData = 9, RULE_formData = 10, 
		RULE_userOption = 11, RULE_locationOption = 12, RULE_loption = 13, RULE_otherOption = 14, 
		RULE_downloadOption = 15, RULE_uploadOption = 16, RULE_url = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"curlCommand", "option", "requestMethod", "headerOption", "proxryOption", 
			"socketOption", "http2Option", "dataOption", "dataUrlEncodeOption", "emptyData", 
			"formData", "userOption", "locationOption", "loption", "otherOption", 
			"downloadOption", "uploadOption", "url"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'curl'", "'-X'", "'--request'", "'-H'", "'--header'", "'-x'", 
			"'--proxy'", "'--socks5-hostname'", "'--http2'", "'-d'", "'--data'", 
			"'--data-ascii'", "'--data-binary'", "'--data-raw'", "'--data-urlencode'", 
			"'-u'", "'--user'", "'-L'", "'--location'", "'--max-redirs'", "'-v'", 
			"'--verbose'", "'-s'", "'--silent'", "'-k'", "'--insecure'", "'-o'", 
			"'-F'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "HTTP_METHOD", "STRING", "WS", "LINE_CONTINUATION", 
			"UNKNOWN", "STRING_EMPTY"
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
			setState(36);
			match(T__0);
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(39);
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
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
					{
					setState(37);
					option();
					}
					break;
				case STRING:
					{
					setState(38);
					url();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1609564156L) != 0) );
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
		public DownloadOptionContext downloadOption() {
			return getRuleContext(DownloadOptionContext.class,0);
		}
		public UploadOptionContext uploadOption() {
			return getRuleContext(UploadOptionContext.class,0);
		}
		public ProxryOptionContext proxryOption() {
			return getRuleContext(ProxryOptionContext.class,0);
		}
		public SocketOptionContext socketOption() {
			return getRuleContext(SocketOptionContext.class,0);
		}
		public Http2OptionContext http2Option() {
			return getRuleContext(Http2OptionContext.class,0);
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				requestMethod();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				headerOption();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				dataOption();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				dataUrlEncodeOption();
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				userOption();
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				locationOption();
				}
				break;
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				otherOption();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				downloadOption();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				uploadOption();
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 10);
				{
				setState(52);
				proxryOption();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 11);
				{
				setState(53);
				socketOption();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 12);
				{
				setState(54);
				http2Option();
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
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(58);
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
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(61);
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
	public static class ProxryOptionContext extends ParserRuleContext {
		public Token proxy;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public ProxryOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proxryOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterProxryOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitProxryOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitProxryOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProxryOptionContext proxryOption() throws RecognitionException {
		ProxryOptionContext _localctx = new ProxryOptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_proxryOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			((ProxryOptionContext)_localctx).proxy = match(STRING);
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
	public static class SocketOptionContext extends ParserRuleContext {
		public Token proxy;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public SocketOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_socketOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterSocketOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitSocketOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitSocketOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SocketOptionContext socketOption() throws RecognitionException {
		SocketOptionContext _localctx = new SocketOptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_socketOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(66);
			match(T__7);
			}
			setState(67);
			((SocketOptionContext)_localctx).proxy = match(STRING);
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
	public static class Http2OptionContext extends ParserRuleContext {
		public Http2OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_http2Option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterHttp2Option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitHttp2Option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitHttp2Option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Http2OptionContext http2Option() throws RecognitionException {
		Http2OptionContext _localctx = new Http2OptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_http2Option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(69);
			match(T__8);
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
		enterRule(_localctx, 14, RULE_dataOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(72);
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
		enterRule(_localctx, 16, RULE_dataUrlEncodeOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__14);
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_EMPTY:
				{
				setState(75);
				emptyData();
				}
				break;
			case STRING:
				{
				setState(76);
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
		enterRule(_localctx, 18, RULE_emptyData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
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
		enterRule(_localctx, 20, RULE_formData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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
		enterRule(_localctx, 22, RULE_userOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(84);
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
		public LoptionContext loption() {
			return getRuleContext(LoptionContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_locationOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(87);
				loption();
				}
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
	public static class LoptionContext extends ParserRuleContext {
		public Token loptionValue;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public LoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterLoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitLoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitLoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoptionContext loption() throws RecognitionException {
		LoptionContext _localctx = new LoptionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(90);
			match(T__19);
			}
			setState(91);
			((LoptionContext)_localctx).loptionValue = match(STRING);
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
		enterRule(_localctx, 28, RULE_otherOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
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
	public static class DownloadOptionContext extends ParserRuleContext {
		public Token file;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public DownloadOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_downloadOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterDownloadOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitDownloadOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitDownloadOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DownloadOptionContext downloadOption() throws RecognitionException {
		DownloadOptionContext _localctx = new DownloadOptionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_downloadOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(95);
			match(T__26);
			}
			setState(96);
			((DownloadOptionContext)_localctx).file = match(STRING);
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
	public static class UploadOptionContext extends ParserRuleContext {
		public Token file;
		public TerminalNode STRING() { return getToken(JThornRuleQuickRestParser.STRING, 0); }
		public UploadOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uploadOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).enterUploadOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickRestListener ) ((JThornRuleQuickRestListener)listener).exitUploadOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickRestVisitor ) return ((JThornRuleQuickRestVisitor<? extends T>)visitor).visitUploadOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UploadOptionContext uploadOption() throws RecognitionException {
		UploadOptionContext _localctx = new UploadOptionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_uploadOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(98);
			match(T__27);
			}
			setState(99);
			((UploadOptionContext)_localctx).file = match(STRING);
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
		enterRule(_localctx, 34, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
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

	public static final String _serializedATN =
		"\u0004\u0001\"h\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0004\u0000(\b\u0000\u000b\u0000\f\u0000)\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00018\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0003\bN\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\fY\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0007\u0001\u0000\u0002\u0003"+
		"\u0001\u0000\u0004\u0005\u0001\u0000\u0006\u0007\u0001\u0000\n\u000e\u0001"+
		"\u0000\u0010\u0011\u0001\u0000\u0012\u0013\u0001\u0000\u0015\u001ad\u0000"+
		"$\u0001\u0000\u0000\u0000\u00027\u0001\u0000\u0000\u0000\u00049\u0001"+
		"\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\b?\u0001\u0000\u0000"+
		"\u0000\nB\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000\u0000\u000eG\u0001"+
		"\u0000\u0000\u0000\u0010J\u0001\u0000\u0000\u0000\u0012O\u0001\u0000\u0000"+
		"\u0000\u0014Q\u0001\u0000\u0000\u0000\u0016S\u0001\u0000\u0000\u0000\u0018"+
		"V\u0001\u0000\u0000\u0000\u001aZ\u0001\u0000\u0000\u0000\u001c]\u0001"+
		"\u0000\u0000\u0000\u001e_\u0001\u0000\u0000\u0000 b\u0001\u0000\u0000"+
		"\u0000\"e\u0001\u0000\u0000\u0000$\'\u0005\u0001\u0000\u0000%(\u0003\u0002"+
		"\u0001\u0000&(\u0003\"\u0011\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		")*\u0001\u0000\u0000\u0000*\u0001\u0001\u0000\u0000\u0000+8\u0003\u0004"+
		"\u0002\u0000,8\u0003\u0006\u0003\u0000-8\u0003\u000e\u0007\u0000.8\u0003"+
		"\u0010\b\u0000/8\u0003\u0016\u000b\u000008\u0003\u0018\f\u000018\u0003"+
		"\u001c\u000e\u000028\u0003\u001e\u000f\u000038\u0003 \u0010\u000048\u0003"+
		"\b\u0004\u000058\u0003\n\u0005\u000068\u0003\f\u0006\u00007+\u0001\u0000"+
		"\u0000\u00007,\u0001\u0000\u0000\u00007-\u0001\u0000\u0000\u00007.\u0001"+
		"\u0000\u0000\u00007/\u0001\u0000\u0000\u000070\u0001\u0000\u0000\u0000"+
		"71\u0001\u0000\u0000\u000072\u0001\u0000\u0000\u000073\u0001\u0000\u0000"+
		"\u000074\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000076\u0001\u0000"+
		"\u0000\u00008\u0003\u0001\u0000\u0000\u00009:\u0007\u0000\u0000\u0000"+
		":;\u0005\u001d\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0007\u0001"+
		"\u0000\u0000=>\u0005\u001e\u0000\u0000>\u0007\u0001\u0000\u0000\u0000"+
		"?@\u0007\u0002\u0000\u0000@A\u0005\u001e\u0000\u0000A\t\u0001\u0000\u0000"+
		"\u0000BC\u0005\b\u0000\u0000CD\u0005\u001e\u0000\u0000D\u000b\u0001\u0000"+
		"\u0000\u0000EF\u0005\t\u0000\u0000F\r\u0001\u0000\u0000\u0000GH\u0007"+
		"\u0003\u0000\u0000HI\u0005\u001e\u0000\u0000I\u000f\u0001\u0000\u0000"+
		"\u0000JM\u0005\u000f\u0000\u0000KN\u0003\u0012\t\u0000LN\u0003\u0014\n"+
		"\u0000MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000N\u0011\u0001"+
		"\u0000\u0000\u0000OP\u0005\"\u0000\u0000P\u0013\u0001\u0000\u0000\u0000"+
		"QR\u0005\u001e\u0000\u0000R\u0015\u0001\u0000\u0000\u0000ST\u0007\u0004"+
		"\u0000\u0000TU\u0005\u001e\u0000\u0000U\u0017\u0001\u0000\u0000\u0000"+
		"VX\u0007\u0005\u0000\u0000WY\u0003\u001a\r\u0000XW\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\u0019\u0001\u0000\u0000\u0000Z[\u0005\u0014"+
		"\u0000\u0000[\\\u0005\u001e\u0000\u0000\\\u001b\u0001\u0000\u0000\u0000"+
		"]^\u0007\u0006\u0000\u0000^\u001d\u0001\u0000\u0000\u0000_`\u0005\u001b"+
		"\u0000\u0000`a\u0005\u001e\u0000\u0000a\u001f\u0001\u0000\u0000\u0000"+
		"bc\u0005\u001c\u0000\u0000cd\u0005\u001e\u0000\u0000d!\u0001\u0000\u0000"+
		"\u0000ef\u0005\u001e\u0000\u0000f#\u0001\u0000\u0000\u0000\u0005\')7M"+
		"X";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}