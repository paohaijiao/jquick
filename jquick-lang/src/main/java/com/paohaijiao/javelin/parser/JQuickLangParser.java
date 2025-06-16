// Generated from D:/idea/jthornruleGrammer/QuickLang/JQuickLang.g4 by ANTLR 4.13.2
package com.paohaijiao.javelin.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JQuickLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RETURN=1, ASSIGN=2, SEMICOLON=3, WITH=4, IF=5, THEN=6, ELSEIF=7, ELSE=8, 
		DOLLAR=9, LPAREN=10, RPAREN=11, LBRACE=12, RBRACE=13, GT=14, GE=15, LT=16, 
		LE=17, EQ=18, NE=19, AND=20, OR=21, ADD=22, MINUS=23, MUL=24, DIV=25, 
		CONTAIN=26, NOTCONTAIN=27, START=28, NOTSTART=29, END=30, NOTEND=31, TRUE=32, 
		FALSE=33, NUMBER=34, TIME=35, DATE=36, YEAR=37, MONTH=38, DAY=39, TIME_ZONE=40, 
		STRING=41, ID=42, WS=43, NEWLINE=44;
	public static final int
		RULE_statement = 0, RULE_rule = 1, RULE_assignment = 2, RULE_elseIfStatment = 3, 
		RULE_elseAction = 4, RULE_action = 5, RULE_returnStatement = 6, RULE_value = 7, 
		RULE_term = 8, RULE_factor = 9, RULE_booleanExpr = 10, RULE_singgelBool = 11, 
		RULE_bool = 12, RULE_numberBool = 13, RULE_stringBool = 14, RULE_dateBool = 15, 
		RULE_number = 16, RULE_string = 17, RULE_date = 18, RULE_variables = 19, 
		RULE_id = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "rule", "assignment", "elseIfStatment", "elseAction", "action", 
			"returnStatement", "value", "term", "factor", "booleanExpr", "singgelBool", 
			"bool", "numberBool", "stringBool", "dateBool", "number", "string", "date", 
			"variables", "id"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return'", "'ASSIGN'", "';'", "'WITH'", "'IF'", "'THEN'", "'ELSEIF'", 
			"'ELSE'", "'$'", "'('", "')'", "'{'", "'}'", "'>'", "'>='", "'<'", "'<='", 
			"'='", "'!='", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'CONTAIN'", 
			"'NOTCONTAIN'", "'START'", "'NOTSTART'", "'END'", "'NOTEND'", "'TRUE'", 
			"'FALSE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RETURN", "ASSIGN", "SEMICOLON", "WITH", "IF", "THEN", "ELSEIF", 
			"ELSE", "DOLLAR", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "GT", "GE", 
			"LT", "LE", "EQ", "NE", "AND", "OR", "ADD", "MINUS", "MUL", "DIV", "CONTAIN", 
			"NOTCONTAIN", "START", "NOTSTART", "END", "NOTEND", "TRUE", "FALSE", 
			"NUMBER", "TIME", "DATE", "YEAR", "MONTH", "DAY", "TIME_ZONE", "STRING", 
			"ID", "WS", "NEWLINE"
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
	public String getGrammarFileName() { return "JQuickLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JQuickLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			rule_();
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
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rule);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				assignment();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				returnStatement();
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
		public TerminalNode IF() { return getToken(JQuickLangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(JQuickLangParser.LPAREN, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JQuickLangParser.RPAREN, 0); }
		public TerminalNode THEN() { return getToken(JQuickLangParser.THEN, 0); }
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
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitAssignment(this);
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
			setState(48);
			match(IF);
			setState(49);
			match(LPAREN);
			setState(50);
			booleanExpr();
			setState(51);
			match(RPAREN);
			setState(52);
			match(THEN);
			setState(53);
			action();
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(54);
				elseIfStatment();
				}
				break;
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(57);
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
		public List<TerminalNode> ELSEIF() { return getTokens(JQuickLangParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(JQuickLangParser.ELSEIF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(JQuickLangParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(JQuickLangParser.LPAREN, i);
		}
		public List<BooleanExprContext> booleanExpr() {
			return getRuleContexts(BooleanExprContext.class);
		}
		public BooleanExprContext booleanExpr(int i) {
			return getRuleContext(BooleanExprContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(JQuickLangParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(JQuickLangParser.RPAREN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(JQuickLangParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(JQuickLangParser.THEN, i);
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
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterElseIfStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitElseIfStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitElseIfStatment(this);
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(60);
				match(ELSEIF);
				setState(61);
				match(LPAREN);
				setState(62);
				booleanExpr();
				setState(63);
				match(RPAREN);
				setState(64);
				match(THEN);
				setState(65);
				action();
				}
				}
				setState(71);
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
		public TerminalNode ELSE() { return getToken(JQuickLangParser.ELSE, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElseActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterElseAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitElseAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitElseAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseActionContext elseAction() throws RecognitionException {
		ElseActionContext _localctx = new ElseActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(ELSE);
			setState(73);
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
		public TerminalNode LBRACE() { return getToken(JQuickLangParser.LBRACE, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TerminalNode EQ() { return getToken(JQuickLangParser.EQ, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JQuickLangParser.RBRACE, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LBRACE);
			setState(76);
			variables();
			setState(77);
			match(EQ);
			setState(78);
			value();
			setState(79);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(JQuickLangParser.RETURN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(JQuickLangParser.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(RETURN);
			setState(82);
			value();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(83);
				match(SEMICOLON);
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
	public static class ValueContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(JQuickLangParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(JQuickLangParser.ADD, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(JQuickLangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(JQuickLangParser.MINUS, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			term();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==MINUS) {
				{
				{
				setState(87);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				term();
				}
				}
				setState(93);
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
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(JQuickLangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(JQuickLangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(JQuickLangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(JQuickLangParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			factor();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(95);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(96);
				factor();
				}
				}
				setState(101);
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JQuickLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JQuickLangParser.RPAREN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(LPAREN);
				setState(103);
				value();
				setState(104);
				match(RPAREN);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				number();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
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
	public static class BooleanExprContext extends ParserRuleContext {
		public List<SinggelBoolContext> singgelBool() {
			return getRuleContexts(SinggelBoolContext.class);
		}
		public SinggelBoolContext singgelBool(int i) {
			return getRuleContext(SinggelBoolContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JQuickLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JQuickLangParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(JQuickLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(JQuickLangParser.OR, i);
		}
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_booleanExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			singgelBool();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(111);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(112);
				singgelBool();
				}
				}
				setState(117);
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
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterSinggelBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitSinggelBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitSinggelBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinggelBoolContext singgelBool() throws RecognitionException {
		SinggelBoolContext _localctx = new SinggelBoolContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singgelBool);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				bool();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				numberBool();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				stringBool();
				}
				break;
			case DOLLAR:
			case TIME:
			case DATE:
			case TIME_ZONE:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				dateBool();
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
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(JQuickLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JQuickLangParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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
		public TerminalNode GT() { return getToken(JQuickLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(JQuickLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(JQuickLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(JQuickLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(JQuickLangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(JQuickLangParser.NE, 0); }
		public NumberBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterNumberBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitNumberBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitNumberBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberBoolContext numberBool() throws RecognitionException {
		NumberBoolContext _localctx = new NumberBoolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_numberBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			number();
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(128);
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
		public TerminalNode CONTAIN() { return getToken(JQuickLangParser.CONTAIN, 0); }
		public TerminalNode NOTCONTAIN() { return getToken(JQuickLangParser.NOTCONTAIN, 0); }
		public TerminalNode START() { return getToken(JQuickLangParser.START, 0); }
		public TerminalNode NOTSTART() { return getToken(JQuickLangParser.NOTSTART, 0); }
		public TerminalNode END() { return getToken(JQuickLangParser.END, 0); }
		public TerminalNode NOTEND() { return getToken(JQuickLangParser.NOTEND, 0); }
		public StringBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterStringBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitStringBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitStringBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringBoolContext stringBool() throws RecognitionException {
		StringBoolContext _localctx = new StringBoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			string();
			setState(131);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(132);
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
		public TerminalNode GT() { return getToken(JQuickLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(JQuickLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(JQuickLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(JQuickLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(JQuickLangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(JQuickLangParser.NE, 0); }
		public DateBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterDateBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitDateBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitDateBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateBoolContext dateBool() throws RecognitionException {
		DateBoolContext _localctx = new DateBoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dateBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			date();
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(136);
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
		public TerminalNode NUMBER() { return getToken(JQuickLangParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JQuickLangParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(JQuickLangParser.TIME, 0); }
		public TerminalNode DATE() { return getToken(JQuickLangParser.DATE, 0); }
		public TerminalNode TIME_ZONE() { return getToken(JQuickLangParser.TIME_ZONE, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_date);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(TIME);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(DATE);
				}
				break;
			case TIME_ZONE:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(TIME_ZONE);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
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
		public TerminalNode DOLLAR() { return getToken(JQuickLangParser.DOLLAR, 0); }
		public TerminalNode LBRACE() { return getToken(JQuickLangParser.LBRACE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JQuickLangParser.RBRACE, 0); }
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(DOLLAR);
			setState(149);
			match(LBRACE);
			setState(150);
			id();
			setState(151);
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
		public TerminalNode ID() { return getToken(JQuickLangParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JQuickLangListener ) ((JQuickLangListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JQuickLangVisitor ) return ((JQuickLangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
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

	public static final String _serializedATN =
		"\u0004\u0001,\u009c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"8\b\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003D\b"+
		"\u0003\n\u0003\f\u0003G\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006U\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007Z\b\u0007\n\u0007\f\u0007]\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0005\bb\b\b\n\b\f\be\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tm\b\t\u0001\n\u0001\n\u0001\n\u0005\nr\b\n\n"+
		"\n\f\nu\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"{\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0093\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0000\u0000\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(\u0000\u0006\u0001\u0000"+
		"\u0016\u0017\u0001\u0000\u0018\u0019\u0001\u0000\u0014\u0015\u0001\u0000"+
		" !\u0001\u0000\u000e\u0013\u0001\u0000\u001a\u001f\u0096\u0000*\u0001"+
		"\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000"+
		"\u0000\u0006E\u0001\u0000\u0000\u0000\bH\u0001\u0000\u0000\u0000\nK\u0001"+
		"\u0000\u0000\u0000\fQ\u0001\u0000\u0000\u0000\u000eV\u0001\u0000\u0000"+
		"\u0000\u0010^\u0001\u0000\u0000\u0000\u0012l\u0001\u0000\u0000\u0000\u0014"+
		"n\u0001\u0000\u0000\u0000\u0016z\u0001\u0000\u0000\u0000\u0018|\u0001"+
		"\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c\u0082\u0001\u0000"+
		"\u0000\u0000\u001e\u0086\u0001\u0000\u0000\u0000 \u008a\u0001\u0000\u0000"+
		"\u0000\"\u008c\u0001\u0000\u0000\u0000$\u0092\u0001\u0000\u0000\u0000"+
		"&\u0094\u0001\u0000\u0000\u0000(\u0099\u0001\u0000\u0000\u0000*+\u0003"+
		"\u0002\u0001\u0000+\u0001\u0001\u0000\u0000\u0000,/\u0003\u0004\u0002"+
		"\u0000-/\u0003\f\u0006\u0000.,\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000"+
		"\u0000/\u0003\u0001\u0000\u0000\u000001\u0005\u0005\u0000\u000012\u0005"+
		"\n\u0000\u000023\u0003\u0014\n\u000034\u0005\u000b\u0000\u000045\u0005"+
		"\u0006\u0000\u000057\u0003\n\u0005\u000068\u0003\u0006\u0003\u000076\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u0000"+
		"9;\u0003\b\u0004\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";\u0005\u0001\u0000\u0000\u0000<=\u0005\u0007\u0000\u0000=>\u0005\n\u0000"+
		"\u0000>?\u0003\u0014\n\u0000?@\u0005\u000b\u0000\u0000@A\u0005\u0006\u0000"+
		"\u0000AB\u0003\n\u0005\u0000BD\u0001\u0000\u0000\u0000C<\u0001\u0000\u0000"+
		"\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"HI\u0005\b\u0000\u0000IJ\u0003\n\u0005\u0000J\t\u0001\u0000\u0000\u0000"+
		"KL\u0005\f\u0000\u0000LM\u0003&\u0013\u0000MN\u0005\u0012\u0000\u0000"+
		"NO\u0003\u000e\u0007\u0000OP\u0005\r\u0000\u0000P\u000b\u0001\u0000\u0000"+
		"\u0000QR\u0005\u0001\u0000\u0000RT\u0003\u000e\u0007\u0000SU\u0005\u0003"+
		"\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U\r\u0001"+
		"\u0000\u0000\u0000V[\u0003\u0010\b\u0000WX\u0007\u0000\u0000\u0000XZ\u0003"+
		"\u0010\b\u0000YW\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u000f\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000^c\u0003\u0012\t\u0000_`\u0007\u0001\u0000"+
		"\u0000`b\u0003\u0012\t\u0000a_\u0001\u0000\u0000\u0000be\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0011\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\n\u0000\u0000gh\u0003"+
		"\u000e\u0007\u0000hi\u0005\u000b\u0000\u0000im\u0001\u0000\u0000\u0000"+
		"jm\u0003 \u0010\u0000km\u0003&\u0013\u0000lf\u0001\u0000\u0000\u0000l"+
		"j\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000m\u0013\u0001\u0000"+
		"\u0000\u0000ns\u0003\u0016\u000b\u0000op\u0007\u0002\u0000\u0000pr\u0003"+
		"\u0016\u000b\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0015\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000v{\u0003\u0018\f\u0000w{\u0003\u001a"+
		"\r\u0000x{\u0003\u001c\u000e\u0000y{\u0003\u001e\u000f\u0000zv\u0001\u0000"+
		"\u0000\u0000zw\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{\u0017\u0001\u0000\u0000\u0000|}\u0007\u0003\u0000"+
		"\u0000}\u0019\u0001\u0000\u0000\u0000~\u007f\u0003 \u0010\u0000\u007f"+
		"\u0080\u0007\u0004\u0000\u0000\u0080\u0081\u0003 \u0010\u0000\u0081\u001b"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0003\"\u0011\u0000\u0083\u0084\u0007"+
		"\u0005\u0000\u0000\u0084\u0085\u0003\"\u0011\u0000\u0085\u001d\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0003$\u0012\u0000\u0087\u0088\u0007\u0004\u0000"+
		"\u0000\u0088\u0089\u0003$\u0012\u0000\u0089\u001f\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\"\u0000\u0000\u008b!\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005)\u0000\u0000\u008d#\u0001\u0000\u0000\u0000\u008e\u0093\u0005"+
		"#\u0000\u0000\u008f\u0093\u0005$\u0000\u0000\u0090\u0093\u0005(\u0000"+
		"\u0000\u0091\u0093\u0003&\u0013\u0000\u0092\u008e\u0001\u0000\u0000\u0000"+
		"\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0091\u0001\u0000\u0000\u0000\u0093%\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\t\u0000\u0000\u0095\u0096\u0005\f\u0000\u0000\u0096\u0097"+
		"\u0003(\u0014\u0000\u0097\u0098\u0005\r\u0000\u0000\u0098\'\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005*\u0000\u0000\u009a)\u0001\u0000\u0000\u0000"+
		"\u000b.7:ET[clsz\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}