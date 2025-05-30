// Generated from D:/idea/jthornruleGrammer/QuickLang/JThornRuleQuickLang.g4 by ANTLR 4.13.2
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
public class JThornRuleQuickLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, SEMICOLON=2, WITH=3, IF=4, THEN=5, ELSEIF=6, ELSE=7, DOLLAR=8, 
		LPAREN=9, RPAREN=10, LBRACE=11, RBRACE=12, GT=13, GE=14, LT=15, LE=16, 
		EQ=17, NE=18, AND=19, OR=20, ADD=21, MINUS=22, MUL=23, DIV=24, CONTAIN=25, 
		NOTCONTAIN=26, START=27, NOTSTART=28, END=29, NOTEND=30, TRUE=31, FALSE=32, 
		NUMBER=33, TIME=34, DATE=35, YEAR=36, MONTH=37, DAY=38, TIME_ZONE=39, 
		STRING=40, ID=41, WS=42, NEWLINE=43;
	public static final int
		RULE_rules = 0, RULE_rule = 1, RULE_assignment = 2, RULE_elseIfStatment = 3, 
		RULE_elseAction = 4, RULE_action = 5, RULE_calculation = 6, RULE_index = 7, 
		RULE_mutiLine = 8, RULE_singleLine = 9, RULE_expr = 10, RULE_booleanExpr = 11, 
		RULE_singgelBool = 12, RULE_bool = 13, RULE_numberBool = 14, RULE_stringBool = 15, 
		RULE_dateBool = 16, RULE_number = 17, RULE_string = 18, RULE_date = 19, 
		RULE_variables = 20, RULE_id = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"rules", "rule", "assignment", "elseIfStatment", "elseAction", "action", 
			"calculation", "index", "mutiLine", "singleLine", "expr", "booleanExpr", 
			"singgelBool", "bool", "numberBool", "stringBool", "dateBool", "number", 
			"string", "date", "variables", "id"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ASSIGN'", "';'", "'WITH'", "'IF'", "'THEN'", "'ELSEIF'", "'ELSE'", 
			"'$'", "'('", "')'", "'{'", "'}'", "'>'", "'>='", "'<'", "'<='", "'='", 
			"'!='", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'CONTAIN'", "'NOTCONTAIN'", 
			"'START'", "'NOTSTART'", "'END'", "'NOTEND'", "'TRUE'", "'FALSE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "SEMICOLON", "WITH", "IF", "THEN", "ELSEIF", "ELSE", 
			"DOLLAR", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "GT", "GE", "LT", "LE", 
			"EQ", "NE", "AND", "OR", "ADD", "MINUS", "MUL", "DIV", "CONTAIN", "NOTCONTAIN", 
			"START", "NOTSTART", "END", "NOTEND", "TRUE", "FALSE", "NUMBER", "TIME", 
			"DATE", "YEAR", "MONTH", "DAY", "TIME_ZONE", "STRING", "ID", "WS", "NEWLINE"
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
	public String getGrammarFileName() { return "JThornRuleQuickLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public JThornRuleQuickLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RulesContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JThornRuleQuickLangParser.EOF, 0); }
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				rule_();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 530L) != 0) );
			setState(49);
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
	public static class RuleContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				assignment();
				}
				break;
			case ASSIGN:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				calculation();
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(JThornRuleQuickLangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(JThornRuleQuickLangParser.LPAREN, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JThornRuleQuickLangParser.RPAREN, 0); }
		public TerminalNode THEN() { return getToken(JThornRuleQuickLangParser.THEN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElseIfStatmentContext elseIfStatment() {
			return getRuleContext(ElseIfStatmentContext.class,0);
		}
		public ElseActionContext elseAction() {
			return getRuleContext(ElseActionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(IF);
			setState(56);
			match(LPAREN);
			setState(57);
			booleanExpr();
			setState(58);
			match(RPAREN);
			setState(59);
			match(THEN);
			setState(60);
			action();
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(61);
				elseIfStatment();
				}
				break;
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(64);
				elseAction();
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
	public static class ElseIfStatmentContext extends ParserRuleContext {
		public List<TerminalNode> ELSEIF() { return getTokens(JThornRuleQuickLangParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(JThornRuleQuickLangParser.ELSEIF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(JThornRuleQuickLangParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(JThornRuleQuickLangParser.LPAREN, i);
		}
		public List<BooleanExprContext> booleanExpr() {
			return getRuleContexts(BooleanExprContext.class);
		}
		public BooleanExprContext booleanExpr(int i) {
			return getRuleContext(BooleanExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(JThornRuleQuickLangParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(JThornRuleQuickLangParser.RPAREN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(JThornRuleQuickLangParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(JThornRuleQuickLangParser.THEN, i);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public ElseIfStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterElseIfStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitElseIfStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitElseIfStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatmentContext elseIfStatment() throws RecognitionException {
		ElseIfStatmentContext _localctx = new ElseIfStatmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elseIfStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(67);
				match(ELSEIF);
				setState(68);
				match(LPAREN);
				setState(69);
				booleanExpr();
				setState(70);
				match(RPAREN);
				setState(71);
				match(THEN);
				setState(72);
				action();
				}
				}
				setState(78);
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
	public static class ElseActionContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(JThornRuleQuickLangParser.ELSE, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElseActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterElseAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitElseAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitElseAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseActionContext elseAction() throws RecognitionException {
		ElseActionContext _localctx = new ElseActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ELSE);
			setState(80);
			action();
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
	public static class ActionContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JThornRuleQuickLangParser.LBRACE, 0); }
		public MutiLineContext mutiLine() {
			return getRuleContext(MutiLineContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JThornRuleQuickLangParser.RBRACE, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(LBRACE);
			setState(83);
			mutiLine();
			setState(84);
			match(RBRACE);
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
	public static class CalculationContext extends ParserRuleContext {
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public CalculationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterCalculation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitCalculation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitCalculation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculationContext calculation() throws RecognitionException {
		CalculationContext _localctx = new CalculationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_calculation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(86);
					index();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(89); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
	public static class IndexContext extends ParserRuleContext {
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
	 
		public IndexContext() { }
		public void copyFrom(IndexContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenIndexContext extends IndexContext {
		public TerminalNode LPAREN() { return getToken(JThornRuleQuickLangParser.LPAREN, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JThornRuleQuickLangParser.RPAREN, 0); }
		public ParenIndexContext(IndexContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterParenIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitParenIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitParenIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MutiLineIndexContext extends IndexContext {
		public MutiLineContext mutiLine() {
			return getRuleContext(MutiLineContext.class,0);
		}
		public MutiLineIndexContext(IndexContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterMutiLineIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitMutiLineIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitMutiLineIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_index);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new ParenIndexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(LPAREN);
				setState(92);
				index();
				setState(93);
				match(RPAREN);
				}
				break;
			case ASSIGN:
				_localctx = new MutiLineIndexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				mutiLine();
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
	public static class MutiLineContext extends ParserRuleContext {
		public List<SingleLineContext> singleLine() {
			return getRuleContexts(SingleLineContext.class);
		}
		public SingleLineContext singleLine(int i) {
			return getRuleContext(SingleLineContext.class,i);
		}
		public MutiLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutiLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterMutiLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitMutiLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitMutiLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MutiLineContext mutiLine() throws RecognitionException {
		MutiLineContext _localctx = new MutiLineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mutiLine);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(98);
					singleLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(101); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
	public static class SingleLineContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(JThornRuleQuickLangParser.ASSIGN, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TerminalNode WITH() { return getToken(JThornRuleQuickLangParser.WITH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(JThornRuleQuickLangParser.SEMICOLON, 0); }
		public SingleLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterSingleLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitSingleLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitSingleLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleLineContext singleLine() throws RecognitionException {
		SingleLineContext _localctx = new SingleLineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_singleLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ASSIGN);
			setState(104);
			variables();
			setState(105);
			match(WITH);
			setState(106);
			expr(0);
			setState(107);
			match(SEMICOLON);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableExprContext extends ExprContext {
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitVariableExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitVariableExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(JThornRuleQuickLangParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(JThornRuleQuickLangParser.MINUS, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExprContext extends ExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitNumberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitNumberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(JThornRuleQuickLangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JThornRuleQuickLangParser.DIV, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(JThornRuleQuickLangParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JThornRuleQuickLangParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitParenExpr(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(110);
				match(LPAREN);
				setState(111);
				expr(0);
				setState(112);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				number();
				}
				break;
			case 3:
				{
				_localctx = new VariableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				variables();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(119);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(120);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(122);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MINUS) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class BooleanExprContext extends ParserRuleContext {
		public List<SinggelBoolContext> singgelBool() {
			return getRuleContexts(SinggelBoolContext.class);
		}
		public SinggelBoolContext singgelBool(int i) {
			return getRuleContext(SinggelBoolContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JThornRuleQuickLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JThornRuleQuickLangParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(JThornRuleQuickLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(JThornRuleQuickLangParser.OR, i);
		}
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_booleanExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			singgelBool();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(131);
				singgelBool();
				}
				}
				setState(136);
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
	public static class SinggelBoolContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public NumberBoolContext numberBool() {
			return getRuleContext(NumberBoolContext.class,0);
		}
		public StringBoolContext stringBool() {
			return getRuleContext(StringBoolContext.class,0);
		}
		public DateBoolContext dateBool() {
			return getRuleContext(DateBoolContext.class,0);
		}
		public SinggelBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singgelBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterSinggelBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitSinggelBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitSinggelBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinggelBoolContext singgelBool() throws RecognitionException {
		SinggelBoolContext _localctx = new SinggelBoolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_singgelBool);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				bool();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				numberBool();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				stringBool();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				dateBool();
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
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(JThornRuleQuickLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JThornRuleQuickLangParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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
	public static class NumberBoolContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode GT() { return getToken(JThornRuleQuickLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(JThornRuleQuickLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(JThornRuleQuickLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(JThornRuleQuickLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(JThornRuleQuickLangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(JThornRuleQuickLangParser.NE, 0); }
		public NumberBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterNumberBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitNumberBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitNumberBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberBoolContext numberBool() throws RecognitionException {
		NumberBoolContext _localctx = new NumberBoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numberBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			number();
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(147);
			number();
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
	public static class StringBoolContext extends ParserRuleContext {
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public TerminalNode CONTAIN() { return getToken(JThornRuleQuickLangParser.CONTAIN, 0); }
		public TerminalNode NOTCONTAIN() { return getToken(JThornRuleQuickLangParser.NOTCONTAIN, 0); }
		public TerminalNode START() { return getToken(JThornRuleQuickLangParser.START, 0); }
		public TerminalNode NOTSTART() { return getToken(JThornRuleQuickLangParser.NOTSTART, 0); }
		public TerminalNode END() { return getToken(JThornRuleQuickLangParser.END, 0); }
		public TerminalNode NOTEND() { return getToken(JThornRuleQuickLangParser.NOTEND, 0); }
		public StringBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterStringBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitStringBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitStringBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringBoolContext stringBool() throws RecognitionException {
		StringBoolContext _localctx = new StringBoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stringBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			string();
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(151);
			string();
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
	public static class DateBoolContext extends ParserRuleContext {
		public List<DateContext> date() {
			return getRuleContexts(DateContext.class);
		}
		public DateContext date(int i) {
			return getRuleContext(DateContext.class,i);
		}
		public TerminalNode GT() { return getToken(JThornRuleQuickLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(JThornRuleQuickLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(JThornRuleQuickLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(JThornRuleQuickLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(JThornRuleQuickLangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(JThornRuleQuickLangParser.NE, 0); }
		public DateBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterDateBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitDateBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitDateBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateBoolContext dateBool() throws RecognitionException {
		DateBoolContext _localctx = new DateBoolContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dateBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			date();
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(155);
			date();
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
		public TerminalNode NUMBER() { return getToken(JThornRuleQuickLangParser.NUMBER, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_number);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(NUMBER);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				variables();
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
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JThornRuleQuickLangParser.STRING, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_string);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(STRING);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				variables();
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(JThornRuleQuickLangParser.TIME, 0); }
		public TerminalNode DATE() { return getToken(JThornRuleQuickLangParser.DATE, 0); }
		public TerminalNode TIME_ZONE() { return getToken(JThornRuleQuickLangParser.TIME_ZONE, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_date);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(TIME);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(DATE);
				}
				break;
			case TIME_ZONE:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(TIME_ZONE);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				variables();
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
	public static class VariablesContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(JThornRuleQuickLangParser.DOLLAR, 0); }
		public TerminalNode LBRACE() { return getToken(JThornRuleQuickLangParser.LBRACE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JThornRuleQuickLangParser.RBRACE, 0); }
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(DOLLAR);
			setState(172);
			match(LBRACE);
			setState(173);
			id();
			setState(174);
			match(RBRACE);
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
	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JThornRuleQuickLangParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JThornRuleQuickLangListener ) ((JThornRuleQuickLangListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JThornRuleQuickLangVisitor ) return ((JThornRuleQuickLangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(ID);
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
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u00b3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0004\u0000.\b\u0000\u000b\u0000\f\u0000/\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002?\b\u0002\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"K\b\u0003\n\u0003\f\u0003N\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006"+
		"X\b\u0006\u000b\u0006\f\u0006Y\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007a\b\u0007\u0001\b\u0004\bd\b\b\u000b\b\f"+
		"\be\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nu\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n}\b\n\n\n\f\n\u0080\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0085\b\u000b\n\u000b\f\u000b\u0088"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u008e\b\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00a0\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00a4\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00aa\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0001\u0014\u0016"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*\u0000\u0006\u0001\u0000\u0017\u0018\u0001\u0000\u0015"+
		"\u0016\u0001\u0000\u0013\u0014\u0001\u0000\u001f \u0001\u0000\r\u0012"+
		"\u0001\u0000\u0019\u001e\u00b1\u0000-\u0001\u0000\u0000\u0000\u00025\u0001"+
		"\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000"+
		"\u0000\bO\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000\u0000\fW\u0001"+
		"\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010c\u0001\u0000\u0000"+
		"\u0000\u0012g\u0001\u0000\u0000\u0000\u0014t\u0001\u0000\u0000\u0000\u0016"+
		"\u0081\u0001\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a"+
		"\u008f\u0001\u0000\u0000\u0000\u001c\u0091\u0001\u0000\u0000\u0000\u001e"+
		"\u0095\u0001\u0000\u0000\u0000 \u0099\u0001\u0000\u0000\u0000\"\u009f"+
		"\u0001\u0000\u0000\u0000$\u00a3\u0001\u0000\u0000\u0000&\u00a9\u0001\u0000"+
		"\u0000\u0000(\u00ab\u0001\u0000\u0000\u0000*\u00b0\u0001\u0000\u0000\u0000"+
		",.\u0003\u0002\u0001\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u0000"+
		"36\u0003\u0004\u0002\u000046\u0003\f\u0006\u000053\u0001\u0000\u0000\u0000"+
		"54\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0005\u0004"+
		"\u0000\u000089\u0005\t\u0000\u00009:\u0003\u0016\u000b\u0000:;\u0005\n"+
		"\u0000\u0000;<\u0005\u0005\u0000\u0000<>\u0003\n\u0005\u0000=?\u0003\u0006"+
		"\u0003\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001"+
		"\u0000\u0000\u0000@B\u0003\b\u0004\u0000A@\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B\u0005\u0001\u0000\u0000\u0000CD\u0005\u0006\u0000"+
		"\u0000DE\u0005\t\u0000\u0000EF\u0003\u0016\u000b\u0000FG\u0005\n\u0000"+
		"\u0000GH\u0005\u0005\u0000\u0000HI\u0003\n\u0005\u0000IK\u0001\u0000\u0000"+
		"\u0000JC\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0007\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000OP\u0005\u0007\u0000\u0000PQ\u0003\n\u0005\u0000"+
		"Q\t\u0001\u0000\u0000\u0000RS\u0005\u000b\u0000\u0000ST\u0003\u0010\b"+
		"\u0000TU\u0005\f\u0000\u0000U\u000b\u0001\u0000\u0000\u0000VX\u0003\u000e"+
		"\u0007\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000\u0000"+
		"[\\\u0005\t\u0000\u0000\\]\u0003\u000e\u0007\u0000]^\u0005\n\u0000\u0000"+
		"^a\u0001\u0000\u0000\u0000_a\u0003\u0010\b\u0000`[\u0001\u0000\u0000\u0000"+
		"`_\u0001\u0000\u0000\u0000a\u000f\u0001\u0000\u0000\u0000bd\u0003\u0012"+
		"\t\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0011\u0001\u0000\u0000\u0000"+
		"gh\u0005\u0001\u0000\u0000hi\u0003(\u0014\u0000ij\u0005\u0003\u0000\u0000"+
		"jk\u0003\u0014\n\u0000kl\u0005\u0002\u0000\u0000l\u0013\u0001\u0000\u0000"+
		"\u0000mn\u0006\n\uffff\uffff\u0000no\u0005\t\u0000\u0000op\u0003\u0014"+
		"\n\u0000pq\u0005\n\u0000\u0000qu\u0001\u0000\u0000\u0000ru\u0003\"\u0011"+
		"\u0000su\u0003(\u0014\u0000tm\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000ts\u0001\u0000\u0000\u0000u~\u0001\u0000\u0000\u0000vw\n\u0002\u0000"+
		"\u0000wx\u0007\u0000\u0000\u0000x}\u0003\u0014\n\u0003yz\n\u0001\u0000"+
		"\u0000z{\u0007\u0001\u0000\u0000{}\u0003\u0014\n\u0002|v\u0001\u0000\u0000"+
		"\u0000|y\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0015\u0001\u0000"+
		"\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0086\u0003\u0018\f"+
		"\u0000\u0082\u0083\u0007\u0002\u0000\u0000\u0083\u0085\u0003\u0018\f\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0017\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0089\u008e\u0003\u001a\r\u0000\u008a\u008e\u0003\u001c\u000e\u0000\u008b"+
		"\u008e\u0003\u001e\u000f\u0000\u008c\u008e\u0003 \u0010\u0000\u008d\u0089"+
		"\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0019"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0007\u0003\u0000\u0000\u0090\u001b"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0003\"\u0011\u0000\u0092\u0093\u0007"+
		"\u0004\u0000\u0000\u0093\u0094\u0003\"\u0011\u0000\u0094\u001d\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0003$\u0012\u0000\u0096\u0097\u0007\u0005\u0000"+
		"\u0000\u0097\u0098\u0003$\u0012\u0000\u0098\u001f\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0003&\u0013\u0000\u009a\u009b\u0007\u0004\u0000\u0000\u009b"+
		"\u009c\u0003&\u0013\u0000\u009c!\u0001\u0000\u0000\u0000\u009d\u00a0\u0005"+
		"!\u0000\u0000\u009e\u00a0\u0003(\u0014\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0#\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0005(\u0000\u0000\u00a2\u00a4\u0003(\u0014\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4%\u0001"+
		"\u0000\u0000\u0000\u00a5\u00aa\u0005\"\u0000\u0000\u00a6\u00aa\u0005#"+
		"\u0000\u0000\u00a7\u00aa\u0005\'\u0000\u0000\u00a8\u00aa\u0003(\u0014"+
		"\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00a9\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\'\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\b\u0000\u0000"+
		"\u00ac\u00ad\u0005\u000b\u0000\u0000\u00ad\u00ae\u0003*\u0015\u0000\u00ae"+
		"\u00af\u0005\f\u0000\u0000\u00af)\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005)\u0000\u0000\u00b1+\u0001\u0000\u0000\u0000\u0010/5>ALY`et|~\u0086"+
		"\u008d\u009f\u00a3\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}