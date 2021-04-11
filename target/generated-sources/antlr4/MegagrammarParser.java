// Generated from Megagrammar.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MegagrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CHARS=1, CODE=2, NONTERMINAL=3, TERMINAL=4, WHITESPACE=5, DOTCOMA=6, EQUALS=7, 
		STICK=8, LBR=9, RBR=10, SQUARE_LBR=11, SQUARE_RBR=12, FIGURE_LBR=13, FIGURE_RBR=14, 
		EMPTY=15;
	public static final int
		RULE_gram = 0, RULE_expression = 1, RULE_initialattributes = 2, RULE_parentattributes = 3, 
		RULE_rules = 4, RULE_onerule = 5, RULE_syntezattributes = 6, RULE_chain = 7, 
		RULE_token = 8, RULE_name = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"gram", "expression", "initialattributes", "parentattributes", "rules", 
			"onerule", "syntezattributes", "chain", "token", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "';'", "'='", "'|'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CHARS", "CODE", "NONTERMINAL", "TERMINAL", "WHITESPACE", "DOTCOMA", 
			"EQUALS", "STICK", "LBR", "RBR", "SQUARE_LBR", "SQUARE_RBR", "FIGURE_LBR", 
			"FIGURE_RBR", "EMPTY"
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
	public String getGrammarFileName() { return "Megagrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MegagrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GramContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterGram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitGram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitGram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL) {
				{
				{
				setState(20);
				expression();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TERMINAL) {
				{
				{
				setState(26);
				token();
				}
				}
				setState(31);
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NONTERMINAL() { return getToken(MegagrammarParser.NONTERMINAL, 0); }
		public TerminalNode EQUALS() { return getToken(MegagrammarParser.EQUALS, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public InitialattributesContext initialattributes() {
			return getRuleContext(InitialattributesContext.class,0);
		}
		public ParentattributesContext parentattributes() {
			return getRuleContext(ParentattributesContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(NONTERMINAL);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBR) {
				{
				setState(33);
				initialattributes();
				}
			}

			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SQUARE_LBR) {
				{
				setState(36);
				parentattributes();
				}
			}

			setState(39);
			match(EQUALS);
			setState(40);
			rules();
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

	public static class InitialattributesContext extends ParserRuleContext {
		public TerminalNode LBR() { return getToken(MegagrammarParser.LBR, 0); }
		public TerminalNode CODE() { return getToken(MegagrammarParser.CODE, 0); }
		public TerminalNode RBR() { return getToken(MegagrammarParser.RBR, 0); }
		public InitialattributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialattributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterInitialattributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitInitialattributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitInitialattributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialattributesContext initialattributes() throws RecognitionException {
		InitialattributesContext _localctx = new InitialattributesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_initialattributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(LBR);
			setState(43);
			match(CODE);
			setState(44);
			match(RBR);
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

	public static class ParentattributesContext extends ParserRuleContext {
		public TerminalNode SQUARE_LBR() { return getToken(MegagrammarParser.SQUARE_LBR, 0); }
		public TerminalNode CODE() { return getToken(MegagrammarParser.CODE, 0); }
		public TerminalNode SQUARE_RBR() { return getToken(MegagrammarParser.SQUARE_RBR, 0); }
		public ParentattributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentattributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterParentattributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitParentattributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitParentattributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentattributesContext parentattributes() throws RecognitionException {
		ParentattributesContext _localctx = new ParentattributesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parentattributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(SQUARE_LBR);
			setState(47);
			match(CODE);
			setState(48);
			match(SQUARE_RBR);
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

	public static class RulesContext extends ParserRuleContext {
		public List<OneruleContext> onerule() {
			return getRuleContexts(OneruleContext.class);
		}
		public OneruleContext onerule(int i) {
			return getRuleContext(OneruleContext.class,i);
		}
		public TerminalNode DOTCOMA() { return getToken(MegagrammarParser.DOTCOMA, 0); }
		public List<TerminalNode> STICK() { return getTokens(MegagrammarParser.STICK); }
		public TerminalNode STICK(int i) {
			return getToken(MegagrammarParser.STICK, i);
		}
		public TerminalNode EMPTY() { return getToken(MegagrammarParser.EMPTY, 0); }
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			onerule();
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					match(STICK);
					setState(52);
					onerule();
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STICK) {
				{
				setState(58);
				match(STICK);
				setState(59);
				match(EMPTY);
				}
			}

			setState(62);
			match(DOTCOMA);
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

	public static class OneruleContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public SyntezattributesContext syntezattributes() {
			return getRuleContext(SyntezattributesContext.class,0);
		}
		public OneruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onerule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterOnerule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitOnerule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitOnerule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneruleContext onerule() throws RecognitionException {
		OneruleContext _localctx = new OneruleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_onerule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FIGURE_LBR) {
				{
				setState(64);
				syntezattributes();
				}
			}

			setState(67);
			chain();
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

	public static class SyntezattributesContext extends ParserRuleContext {
		public TerminalNode FIGURE_LBR() { return getToken(MegagrammarParser.FIGURE_LBR, 0); }
		public TerminalNode CODE() { return getToken(MegagrammarParser.CODE, 0); }
		public TerminalNode FIGURE_RBR() { return getToken(MegagrammarParser.FIGURE_RBR, 0); }
		public SyntezattributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntezattributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterSyntezattributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitSyntezattributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitSyntezattributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntezattributesContext syntezattributes() throws RecognitionException {
		SyntezattributesContext _localctx = new SyntezattributesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_syntezattributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(FIGURE_LBR);
			setState(70);
			match(CODE);
			setState(71);
			match(FIGURE_RBR);
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

	public static class ChainContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				name();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NONTERMINAL || _la==TERMINAL );
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

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(MegagrammarParser.TERMINAL, 0); }
		public TerminalNode EQUALS() { return getToken(MegagrammarParser.EQUALS, 0); }
		public TerminalNode CHARS() { return getToken(MegagrammarParser.CHARS, 0); }
		public TerminalNode DOTCOMA() { return getToken(MegagrammarParser.DOTCOMA, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(TERMINAL);
			setState(79);
			match(EQUALS);
			setState(80);
			match(CHARS);
			setState(81);
			match(DOTCOMA);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(MegagrammarParser.TERMINAL, 0); }
		public TerminalNode NONTERMINAL() { return getToken(MegagrammarParser.NONTERMINAL, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MegagrammarListener ) ((MegagrammarListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegagrammarVisitor ) return ((MegagrammarVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==NONTERMINAL || _la==TERMINAL) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\5"+
		"\3%\n\3\3\3\5\3(\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\7\68\n\6\f\6\16\6;\13\6\3\6\3\6\5\6?\n\6\3\6\3\6\3\7\5\7D\n\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\t\6\tM\n\t\r\t\16\tN\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\5\6\2U\2\31\3\2\2\2\4"+
		"\"\3\2\2\2\6,\3\2\2\2\b\60\3\2\2\2\n\64\3\2\2\2\fC\3\2\2\2\16G\3\2\2\2"+
		"\20L\3\2\2\2\22P\3\2\2\2\24U\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\33"+
		"\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\37\3\2\2\2\33\31\3\2\2\2\34\36"+
		"\5\22\n\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2"+
		"\2!\37\3\2\2\2\"$\7\5\2\2#%\5\6\4\2$#\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&(\5"+
		"\b\5\2\'&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\t\2\2*+\5\n\6\2+\5\3\2\2\2"+
		",-\7\13\2\2-.\7\4\2\2./\7\f\2\2/\7\3\2\2\2\60\61\7\r\2\2\61\62\7\4\2\2"+
		"\62\63\7\16\2\2\63\t\3\2\2\2\649\5\f\7\2\65\66\7\n\2\2\668\5\f\7\2\67"+
		"\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:>\3\2\2\2;9\3\2\2\2<=\7\n"+
		"\2\2=?\7\21\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\b\2\2A\13\3\2\2\2BD"+
		"\5\16\b\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\5\20\t\2F\r\3\2\2\2GH\7\17\2"+
		"\2HI\7\4\2\2IJ\7\20\2\2J\17\3\2\2\2KM\5\24\13\2LK\3\2\2\2MN\3\2\2\2NL"+
		"\3\2\2\2NO\3\2\2\2O\21\3\2\2\2PQ\7\6\2\2QR\7\t\2\2RS\7\3\2\2ST\7\b\2\2"+
		"T\23\3\2\2\2UV\t\2\2\2V\25\3\2\2\2\n\31\37$\'9>CN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}