// Generated from Megagrammar.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MegagrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CHARS=1, CODE=2, NONTERMINAL=3, TERMINAL=4, WHITESPACE=5, DOTCOMA=6, EQUALS=7, 
		STICK=8, LBR=9, RBR=10, SQUARE_LBR=11, SQUARE_RBR=12, FIGURE_LBR=13, FIGURE_RBR=14, 
		EMPTY=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CHARS", "CODE", "NONTERMINAL", "TERMINAL", "WHITESPACE", "DOTCOMA", 
			"EQUALS", "STICK", "LBR", "RBR", "SQUARE_LBR", "SQUARE_RBR", "FIGURE_LBR", 
			"FIGURE_RBR", "EMPTY"
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


	public MegagrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Megagrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21Y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\6\2$\n\2\r\2"+
		"\16\2%\3\2\3\2\3\3\3\3\6\3,\n\3\r\3\16\3-\3\3\3\3\3\4\3\4\7\4\64\n\4\f"+
		"\4\16\4\67\13\4\3\5\6\5:\n\5\r\5\16\5;\3\6\6\6?\n\6\r\6\16\6@\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21\3\2\b\3\2$$\3\2BB\3\2c|\4\2C\\c|\3"+
		"\2C\\\5\2\13\f\17\17\"\"\2]\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\3!\3\2\2\2\5)\3\2\2\2\7\61\3\2\2\2\t9\3\2\2\2\13>\3\2\2\2\rD"+
		"\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31"+
		"P\3\2\2\2\33R\3\2\2\2\35T\3\2\2\2\37V\3\2\2\2!#\7$\2\2\"$\n\2\2\2#\"\3"+
		"\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7$\2\2(\4\3\2\2\2)"+
		"+\7B\2\2*,\n\3\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2/"+
		"\60\7B\2\2\60\6\3\2\2\2\61\65\t\4\2\2\62\64\t\5\2\2\63\62\3\2\2\2\64\67"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\b\3\2\2\2\67\65\3\2\2\28:\t\6"+
		"\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\n\3\2\2\2=?\t\7\2\2>=\3"+
		"\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\b\6\2\2C\f\3\2\2\2DE"+
		"\7=\2\2E\16\3\2\2\2FG\7?\2\2G\20\3\2\2\2HI\7~\2\2I\22\3\2\2\2JK\7*\2\2"+
		"K\24\3\2\2\2LM\7+\2\2M\26\3\2\2\2NO\7]\2\2O\30\3\2\2\2PQ\7_\2\2Q\32\3"+
		"\2\2\2RS\7}\2\2S\34\3\2\2\2TU\7\177\2\2U\36\3\2\2\2VW\7>\2\2WX\7@\2\2"+
		"X \3\2\2\2\b\2%-\65;@\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}