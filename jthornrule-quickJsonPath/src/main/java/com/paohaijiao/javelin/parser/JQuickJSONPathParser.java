package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/JSONPath/JQuickJSONPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JQuickJSONPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, IDENTIFIER=31, 
		STRING=32, NUMBER=33, WS=34, REGEX_CHAR=35, ESCAPE_SEQ=36, REGEX_FLAGS=37;
	public static final int
		RULE_path = 0, RULE_root = 1, RULE_segment = 2, RULE_subscript = 3, RULE_filterExpression = 4, 
		RULE_slice = 5, RULE_scriptExpression = 6, RULE_expr = 7, RULE_valueList = 8, 
		RULE_regexLiteral = 9, RULE_exprList = 10, RULE_identifier = 11, RULE_literal = 12, 
		RULE_stringLiteral = 13, RULE_number = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"path", "root", "segment", "subscript", "filterExpression", "slice", 
			"scriptExpression", "expr", "valueList", "regexLiteral", "exprList", 
			"identifier", "literal", "stringLiteral", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$'", "'@'", "'.'", "'*'", "'['", "']'", "'..'", "','", "'?'", 
			"'('", "')'", "':'", "'-'", "'!'", "'/'", "'%'", "'+'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", "'=~'", "'in'", "'&&'", "'||'", "'true'", 
			"'false'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IDENTIFIER", "STRING", "NUMBER", 
			"WS", "REGEX_CHAR", "ESCAPE_SEQ", "REGEX_FLAGS"
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
	public String getGrammarFileName() { return "JQuickJSONPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JQuickJSONPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public RootContext root() {
			return getRuleContext(RootContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JQuickJSONPathParser.EOF, 0); }
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			root();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 168L) != 0)) {
				{
				{
				setState(31);
				segment();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
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
	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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
	public static class SegmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SubscriptContext subscript() {
			return getRuleContext(SubscriptContext.class,0);
		}
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_segment);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(T__2);
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case STRING:
					{
					setState(42);
					identifier();
					}
					break;
				case T__3:
					{
					setState(43);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(T__4);
				setState(47);
				subscript(0);
				setState(48);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(T__6);
				setState(53);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case STRING:
					{
					setState(51);
					identifier();
					}
					break;
				case T__3:
					{
					setState(52);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(T__6);
				setState(56);
				match(T__4);
				setState(57);
				subscript(0);
				setState(58);
				match(T__5);
				}
				break;
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
	public static class SubscriptContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public SliceContext slice() {
			return getRuleContext(SliceContext.class,0);
		}
		public ScriptExpressionContext scriptExpression() {
			return getRuleContext(ScriptExpressionContext.class,0);
		}
		public FilterExpressionContext filterExpression() {
			return getRuleContext(FilterExpressionContext.class,0);
		}
		public List<SubscriptContext> subscript() {
			return getRuleContexts(SubscriptContext.class);
		}
		public SubscriptContext subscript(int i) {
			return getRuleContext(SubscriptContext.class,i);
		}
		public SubscriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptContext subscript() throws RecognitionException {
		return subscript(0);
	}

	private SubscriptContext subscript(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SubscriptContext _localctx = new SubscriptContext(_ctx, _parentState);
		SubscriptContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_subscript, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(63);
				number();
				}
				break;
			case 2:
				{
				setState(64);
				match(T__3);
				}
				break;
			case 3:
				{
				setState(65);
				stringLiteral();
				}
				break;
			case 4:
				{
				setState(66);
				slice();
				}
				break;
			case 5:
				{
				setState(67);
				scriptExpression();
				}
				break;
			case 6:
				{
				setState(68);
				filterExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SubscriptContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_subscript);
					setState(71);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(72);
					match(T__7);
					setState(73);
					subscript(2);
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FilterExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitFilterExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitFilterExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterExpressionContext filterExpression() throws RecognitionException {
		FilterExpressionContext _localctx = new FilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filterExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__8);
			setState(80);
			match(T__9);
			setState(81);
			expr(0);
			setState(82);
			match(T__10);
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
	public static class SliceContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterSlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitSlice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitSlice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_slice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(84);
				number();
				}
			}

			setState(87);
			match(T__11);
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(88);
				number();
				}
				break;
			}
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(91);
				match(T__11);
				setState(93);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(92);
					number();
					}
					break;
				}
				}
				break;
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
	public static class ScriptExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ScriptExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterScriptExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitScriptExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitScriptExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptExpressionContext scriptExpression() throws RecognitionException {
		ScriptExpressionContext _localctx = new ScriptExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_scriptExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__9);
			setState(98);
			expr(0);
			setState(99);
			match(T__10);
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
	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SubscriptContext subscript() {
			return getRuleContext(SubscriptContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public RegexLiteralContext regexLiteral() {
			return getRuleContext(RegexLiteralContext.class,0);
		}
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(102);
				match(T__12);
				setState(103);
				expr(15);
				}
				break;
			case 2:
				{
				setState(104);
				match(T__13);
				setState(105);
				expr(14);
				}
				break;
			case 3:
				{
				setState(106);
				literal();
				}
				break;
			case 4:
				{
				setState(107);
				identifier();
				}
				break;
			case 5:
				{
				setState(108);
				match(T__0);
				}
				break;
			case 6:
				{
				setState(109);
				match(T__1);
				}
				break;
			case 7:
				{
				setState(110);
				match(T__9);
				setState(111);
				expr(0);
				setState(112);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(117);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 98320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(120);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__16) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(123);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(126);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(129);
						match(T__25);
						setState(130);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(132);
						match(T__26);
						setState(133);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(135);
						match(T__2);
						setState(138);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IDENTIFIER:
						case STRING:
							{
							setState(136);
							identifier();
							}
							break;
						case T__3:
							{
							setState(137);
							match(T__3);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(141);
						match(T__4);
						setState(142);
						subscript(0);
						setState(143);
						match(T__5);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(146);
						match(T__9);
						setState(148);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911459334L) != 0)) {
							{
							setState(147);
							exprList();
							}
						}

						setState(150);
						match(T__10);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(152);
						match(T__23);
						setState(153);
						regexLiteral();
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(155);
						match(T__24);
						setState(156);
						valueList();
						}
						break;
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueListContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__9);
			setState(163);
			literal();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(164);
				match(T__7);
				setState(165);
				literal();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			match(T__10);
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
	public static class RegexLiteralContext extends ParserRuleContext {
		public TerminalNode REGEX_FLAGS() { return getToken(JQuickJSONPathParser.REGEX_FLAGS, 0); }
		public List<TerminalNode> REGEX_CHAR() { return getTokens(JQuickJSONPathParser.REGEX_CHAR); }
		public TerminalNode REGEX_CHAR(int i) {
			return getToken(JQuickJSONPathParser.REGEX_CHAR, i);
		}
		public List<TerminalNode> ESCAPE_SEQ() { return getTokens(JQuickJSONPathParser.ESCAPE_SEQ); }
		public TerminalNode ESCAPE_SEQ(int i) {
			return getToken(JQuickJSONPathParser.ESCAPE_SEQ, i);
		}
		public RegexLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterRegexLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitRegexLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitRegexLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegexLiteralContext regexLiteral() throws RecognitionException {
		RegexLiteralContext _localctx = new RegexLiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_regexLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__14);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==REGEX_CHAR || _la==ESCAPE_SEQ) {
				{
				{
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==REGEX_CHAR || _la==ESCAPE_SEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			match(T__14);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(181);
				match(REGEX_FLAGS);
				}
				break;
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
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			expr(0);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(185);
				match(T__7);
				setState(186);
				expr(0);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JQuickJSONPathParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(JQuickJSONPathParser.STRING, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
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
	public static class LiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				stringLiteral();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				number();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				match(T__29);
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
	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JQuickJSONPathParser.STRING, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(JQuickJSONPathParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickJSONPathListener ) ((JQuickJSONPathListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickJSONPathVisitor) return ((JQuickJSONPathVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(NUMBER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return subscript_sempred((SubscriptContext)_localctx, predIndex);
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean subscript_sempred(SubscriptContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00ce\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"-\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003F\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"K\b\u0003\n\u0003\f\u0003N\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005V\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005Z\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"^\b\u0005\u0003\u0005`\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007s\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u008b\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0095\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u009e\b\u0007\n\u0007\f\u0007"+
		"\u00a1\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a7\b\b\n\b\f"+
		"\b\u00aa\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u00b0\b\t\n\t\f\t"+
		"\u00b3\t\t\u0001\t\u0001\t\u0003\t\u00b7\b\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00bc\b\n\n\n\f\n\u00bf\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00c8\b\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0000\u0002\u0006\u000e\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0007"+
		"\u0001\u0000\u0001\u0002\u0002\u0000\u0004\u0004\u000f\u0010\u0002\u0000"+
		"\r\r\u0011\u0011\u0001\u0000\u0012\u0015\u0001\u0000\u0016\u0017\u0001"+
		"\u0000#$\u0001\u0000\u001f \u00e9\u0000\u001e\u0001\u0000\u0000\u0000"+
		"\u0002\'\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006"+
		"E\u0001\u0000\u0000\u0000\bO\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000"+
		"\u0000\fa\u0001\u0000\u0000\u0000\u000er\u0001\u0000\u0000\u0000\u0010"+
		"\u00a2\u0001\u0000\u0000\u0000\u0012\u00ad\u0001\u0000\u0000\u0000\u0014"+
		"\u00b8\u0001\u0000\u0000\u0000\u0016\u00c0\u0001\u0000\u0000\u0000\u0018"+
		"\u00c7\u0001\u0000\u0000\u0000\u001a\u00c9\u0001\u0000\u0000\u0000\u001c"+
		"\u00cb\u0001\u0000\u0000\u0000\u001e\"\u0003\u0002\u0001\u0000\u001f!"+
		"\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001"+
		"&\u0001\u0001\u0000\u0000\u0000\'(\u0007\u0000\u0000\u0000(\u0003\u0001"+
		"\u0000\u0000\u0000),\u0005\u0003\u0000\u0000*-\u0003\u0016\u000b\u0000"+
		"+-\u0005\u0004\u0000\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000"+
		"\u0000-=\u0001\u0000\u0000\u0000./\u0005\u0005\u0000\u0000/0\u0003\u0006"+
		"\u0003\u000001\u0005\u0006\u0000\u00001=\u0001\u0000\u0000\u000025\u0005"+
		"\u0007\u0000\u000036\u0003\u0016\u000b\u000046\u0005\u0004\u0000\u0000"+
		"53\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006=\u0001\u0000\u0000"+
		"\u000078\u0005\u0007\u0000\u000089\u0005\u0005\u0000\u00009:\u0003\u0006"+
		"\u0003\u0000:;\u0005\u0006\u0000\u0000;=\u0001\u0000\u0000\u0000<)\u0001"+
		"\u0000\u0000\u0000<.\u0001\u0000\u0000\u0000<2\u0001\u0000\u0000\u0000"+
		"<7\u0001\u0000\u0000\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0006\u0003"+
		"\uffff\uffff\u0000?F\u0003\u001c\u000e\u0000@F\u0005\u0004\u0000\u0000"+
		"AF\u0003\u001a\r\u0000BF\u0003\n\u0005\u0000CF\u0003\f\u0006\u0000DF\u0003"+
		"\b\u0004\u0000E>\u0001\u0000\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001"+
		"\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"ED\u0001\u0000\u0000\u0000FL\u0001\u0000\u0000\u0000GH\n\u0001\u0000\u0000"+
		"HI\u0005\b\u0000\u0000IK\u0003\u0006\u0003\u0002JG\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000M\u0007\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0005"+
		"\t\u0000\u0000PQ\u0005\n\u0000\u0000QR\u0003\u000e\u0007\u0000RS\u0005"+
		"\u000b\u0000\u0000S\t\u0001\u0000\u0000\u0000TV\u0003\u001c\u000e\u0000"+
		"UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WY\u0005\f\u0000\u0000XZ\u0003\u001c\u000e\u0000YX\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z_\u0001\u0000\u0000\u0000[]\u0005\f\u0000"+
		"\u0000\\^\u0003\u001c\u000e\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^`\u0001\u0000\u0000\u0000_[\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0005\n\u0000\u0000"+
		"bc\u0003\u000e\u0007\u0000cd\u0005\u000b\u0000\u0000d\r\u0001\u0000\u0000"+
		"\u0000ef\u0006\u0007\uffff\uffff\u0000fg\u0005\r\u0000\u0000gs\u0003\u000e"+
		"\u0007\u000fhi\u0005\u000e\u0000\u0000is\u0003\u000e\u0007\u000ejs\u0003"+
		"\u0018\f\u0000ks\u0003\u0016\u000b\u0000ls\u0005\u0001\u0000\u0000ms\u0005"+
		"\u0002\u0000\u0000no\u0005\n\u0000\u0000op\u0003\u000e\u0007\u0000pq\u0005"+
		"\u000b\u0000\u0000qs\u0001\u0000\u0000\u0000re\u0001\u0000\u0000\u0000"+
		"rh\u0001\u0000\u0000\u0000rj\u0001\u0000\u0000\u0000rk\u0001\u0000\u0000"+
		"\u0000rl\u0001\u0000\u0000\u0000rm\u0001\u0000\u0000\u0000rn\u0001\u0000"+
		"\u0000\u0000s\u009f\u0001\u0000\u0000\u0000tu\n\r\u0000\u0000uv\u0007"+
		"\u0001\u0000\u0000v\u009e\u0003\u000e\u0007\u000ewx\n\f\u0000\u0000xy"+
		"\u0007\u0002\u0000\u0000y\u009e\u0003\u000e\u0007\rz{\n\u000b\u0000\u0000"+
		"{|\u0007\u0003\u0000\u0000|\u009e\u0003\u000e\u0007\f}~\n\n\u0000\u0000"+
		"~\u007f\u0007\u0004\u0000\u0000\u007f\u009e\u0003\u000e\u0007\u000b\u0080"+
		"\u0081\n\u0007\u0000\u0000\u0081\u0082\u0005\u001a\u0000\u0000\u0082\u009e"+
		"\u0003\u000e\u0007\b\u0083\u0084\n\u0006\u0000\u0000\u0084\u0085\u0005"+
		"\u001b\u0000\u0000\u0085\u009e\u0003\u000e\u0007\u0007\u0086\u0087\n\u0012"+
		"\u0000\u0000\u0087\u008a\u0005\u0003\u0000\u0000\u0088\u008b\u0003\u0016"+
		"\u000b\u0000\u0089\u008b\u0005\u0004\u0000\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u009e\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\n\u0011\u0000\u0000\u008d\u008e\u0005\u0005\u0000"+
		"\u0000\u008e\u008f\u0003\u0006\u0003\u0000\u008f\u0090\u0005\u0006\u0000"+
		"\u0000\u0090\u009e\u0001\u0000\u0000\u0000\u0091\u0092\n\u0010\u0000\u0000"+
		"\u0092\u0094\u0005\n\u0000\u0000\u0093\u0095\u0003\u0014\n\u0000\u0094"+
		"\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u009e\u0005\u000b\u0000\u0000\u0097"+
		"\u0098\n\t\u0000\u0000\u0098\u0099\u0005\u0018\u0000\u0000\u0099\u009e"+
		"\u0003\u0012\t\u0000\u009a\u009b\n\b\u0000\u0000\u009b\u009c\u0005\u0019"+
		"\u0000\u0000\u009c\u009e\u0003\u0010\b\u0000\u009dt\u0001\u0000\u0000"+
		"\u0000\u009dw\u0001\u0000\u0000\u0000\u009dz\u0001\u0000\u0000\u0000\u009d"+
		"}\u0001\u0000\u0000\u0000\u009d\u0080\u0001\u0000\u0000\u0000\u009d\u0083"+
		"\u0001\u0000\u0000\u0000\u009d\u0086\u0001\u0000\u0000\u0000\u009d\u008c"+
		"\u0001\u0000\u0000\u0000\u009d\u0091\u0001\u0000\u0000\u0000\u009d\u0097"+
		"\u0001\u0000\u0000\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009e\u00a1"+
		"\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3\u00a8\u0003"+
		"\u0018\f\u0000\u00a4\u00a5\u0005\b\u0000\u0000\u00a5\u00a7\u0003\u0018"+
		"\f\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u000b\u0000\u0000\u00ac\u0011\u0001\u0000\u0000"+
		"\u0000\u00ad\u00b1\u0005\u000f\u0000\u0000\u00ae\u00b0\u0007\u0005\u0000"+
		"\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b6\u0005\u000f\u0000\u0000\u00b5\u00b7\u0005%\u0000\u0000"+
		"\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u0013\u0001\u0000\u0000\u0000\u00b8\u00bd\u0003\u000e\u0007\u0000"+
		"\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00bc\u0003\u000e\u0007\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u0015\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0007\u0006\u0000\u0000\u00c1\u0017\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c8\u0003\u001a\r\u0000\u00c3\u00c8\u0003\u001c\u000e\u0000\u00c4\u00c8"+
		"\u0005\u001c\u0000\u0000\u00c5\u00c8\u0005\u001d\u0000\u0000\u00c6\u00c8"+
		"\u0005\u001e\u0000\u0000\u00c7\u00c2\u0001\u0000\u0000\u0000\u00c7\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u0019"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005 \u0000\u0000\u00ca\u001b\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0005!\u0000\u0000\u00cc\u001d\u0001\u0000"+
		"\u0000\u0000\u0014\",5<ELUY]_r\u008a\u0094\u009d\u009f\u00a8\u00b1\u00b6"+
		"\u00bd\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}