// Generated from C:/Users/k-sam/Documents/Projets/COURS/A1/SELP/CCalc/src/parser\Calc.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BOOLEAN=8, OP1=9, 
		OP2=10, OP3=11, OP4=12, OP5=13, OP6=14, IDENTIFIER=15, LITERAL=16, WS=17, 
		LINE_COMMENT=18;
	public static final int
		RULE_program = 0, RULE_funcDef = 1, RULE_head = 2, RULE_body = 3, RULE_varDef = 4, 
		RULE_expression = 5, RULE_tail = 6, RULE_variableId = 7, RULE_functionId = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcDef", "head", "body", "varDef", "expression", "tail", 
			"variableId", "functionId"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "'-'", "'!'", "':'", "'?'", null, null, null, 
			null, null, "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "BOOLEAN", "OP1", "OP2", 
			"OP3", "OP4", "OP5", "OP6", "IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18);
					funcDef();
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(24);
			body();
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

	public static class FuncDefContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			head();
			setState(27);
			body();
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

	public static class HeadContext extends ParserRuleContext {
		public FunctionIdContext functionId() {
			return getRuleContext(FunctionIdContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			functionId();
			setState(30);
			match(T__0);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(31);
				variableId();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(T__1);
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

	public static class BodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39);
					varDef();
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(45);
			expression(0);
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

	public static class VarDefContext extends ParserRuleContext {
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDef);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				variableId();
				setState(48);
				match(T__2);
				setState(49);
				expression(0);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(T__0);
				setState(52);
				variableId();
				setState(53);
				match(T__2);
				setState(54);
				expression(0);
				setState(55);
				match(T__1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarCallContext extends ExpressionContext {
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public VarCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterVarCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitVarCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitVarCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinExpContext extends ExpressionContext {
		public TerminalNode OP1() { return getToken(CalcParser.OP1, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OP2() { return getToken(CalcParser.OP2, 0); }
		public TerminalNode OP3() { return getToken(CalcParser.OP3, 0); }
		public TerminalNode OP4() { return getToken(CalcParser.OP4, 0); }
		public TerminalNode OP5() { return getToken(CalcParser.OP5, 0); }
		public TerminalNode OP6() { return getToken(CalcParser.OP6, 0); }
		public BinExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterBinExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitBinExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitBinExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SyntaxErrorContext extends ExpressionContext {
		public List<TerminalNode> LITERAL() { return getTokens(CalcParser.LITERAL); }
		public TerminalNode LITERAL(int i) {
			return getToken(CalcParser.LITERAL, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SyntaxErrorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterSyntaxError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitSyntaxError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitSyntaxError(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(CalcParser.BOOLEAN, 0); }
		public BooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunCallContext extends ExpressionContext {
		public FunctionIdContext functionId() {
			return getRuleContext(FunctionIdContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public List<TerminalNode> LITERAL() { return getTokens(CalcParser.LITERAL); }
		public TerminalNode LITERAL(int i) {
			return getToken(CalcParser.LITERAL, i);
		}
		public FunCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CondExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterCondExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitCondExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitCondExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterUnExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitUnExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitUnExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLitContext extends ExpressionContext {
		public TerminalNode LITERAL() { return getToken(CalcParser.LITERAL, 0); }
		public IntLitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitIntLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitIntLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(60);
				match(T__0);
				setState(61);
				match(OP1);
				setState(62);
				expression(0);
				setState(63);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new UnExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__0);
				setState(66);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				expression(0);
				setState(68);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new UnExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(71);
				expression(26);
				}
				break;
			case 4:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(T__0);
				setState(73);
				expression(0);
				setState(74);
				match(OP2);
				setState(75);
				expression(0);
				setState(76);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(T__0);
				setState(79);
				expression(0);
				setState(80);
				match(OP3);
				setState(81);
				expression(0);
				setState(82);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(T__0);
				setState(85);
				expression(0);
				setState(86);
				match(OP4);
				setState(87);
				expression(0);
				setState(88);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(T__0);
				setState(91);
				expression(0);
				setState(92);
				match(OP5);
				setState(93);
				expression(0);
				setState(94);
				match(T__1);
				}
				break;
			case 8:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(T__0);
				setState(97);
				expression(0);
				setState(98);
				match(OP6);
				setState(99);
				expression(0);
				setState(100);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new BinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(T__0);
				setState(103);
				expression(0);
				setState(104);
				match(T__3);
				setState(105);
				expression(0);
				setState(106);
				match(T__1);
				}
				break;
			case 10:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(T__0);
				setState(109);
				match(LITERAL);
				setState(110);
				match(T__1);
				}
				break;
			case 11:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(LITERAL);
				}
				break;
			case 12:
				{
				_localctx = new SyntaxErrorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(LITERAL);
				setState(113);
				match(LITERAL);
				}
				break;
			case 13:
				{
				_localctx = new SyntaxErrorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(T__0);
				setState(115);
				match(LITERAL);
				setState(116);
				match(LITERAL);
				setState(117);
				match(T__1);
				}
				break;
			case 14:
				{
				_localctx = new UnExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(T__0);
				setState(119);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(120);
				expression(0);
				setState(121);
				match(T__1);
				}
				break;
			case 15:
				{
				_localctx = new VarCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				variableId();
				}
				break;
			case 16:
				{
				_localctx = new FunCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				functionId();
				setState(125);
				match(T__0);
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDENTIFIER) {
						{
						{
						setState(126);
						variableId();
						}
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==LITERAL) {
						{
						{
						setState(132);
						match(LITERAL);
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(140);
				match(T__1);
				}
				break;
			case 17:
				{
				_localctx = new ExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__0);
				setState(143);
				expression(0);
				setState(144);
				match(T__1);
				}
				break;
			case 18:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(BOOLEAN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(150);
						match(T__3);
						setState(151);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(153);
						match(OP1);
						setState(154);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(156);
						match(OP2);
						setState(157);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(159);
						match(OP3);
						setState(160);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(162);
						match(OP4);
						setState(163);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(165);
						match(OP5);
						setState(166);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new BinExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(168);
						match(OP6);
						setState(169);
						expression(14);
						}
						break;
					case 8:
						{
						_localctx = new SyntaxErrorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(171);
						match(T__6);
						setState(172);
						expression(0);
						setState(173);
						match(T__5);
						setState(174);
						expression(0);
						setState(175);
						match(T__6);
						setState(176);
						expression(3);
						}
						break;
					case 9:
						{
						_localctx = new CondExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(179);
						match(T__6);
						setState(180);
						expression(0);
						setState(181);
						match(T__5);
						setState(182);
						expression(2);
						}
						break;
					case 10:
						{
						_localctx = new SyntaxErrorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(185);
						match(T__5);
						setState(186);
						expression(0);
						setState(187);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class TailContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tail);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(T__1);
				}
				break;
			case T__0:
			case T__3:
			case T__4:
			case BOOLEAN:
			case IDENTIFIER:
			case LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				expression(0);
				setState(196);
				match(T__1);
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

	public static class VariableIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CalcParser.IDENTIFIER, 0); }
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IDENTIFIER);
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

	public static class FunctionIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CalcParser.IDENTIFIER, 0); }
		public FunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterFunctionId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitFunctionId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitFunctionId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdContext functionId() throws RecognitionException {
		FunctionIdContext _localctx = new FunctionIdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(IDENTIFIER);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u00cf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7"+
		"\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\7\4#\n\4\f"+
		"\4\16\4&\13\4\3\4\3\4\3\5\7\5+\n\5\f\5\16\5.\13\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0082\n\7\f\7\16\7\u0085\13\7\3\7\7"+
		"\7\u0088\n\7\f\7\16\7\u008b\13\7\5\7\u008d\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u0096\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00c0\n\7\f\7\16\7\u00c3\13"+
		"\7\3\b\3\b\3\b\3\b\5\b\u00c9\n\b\3\t\3\t\3\n\3\n\3\n\2\3\f\13\2\4\6\b"+
		"\n\f\16\20\22\2\3\3\2\6\7\2\u00e8\2\27\3\2\2\2\4\34\3\2\2\2\6\37\3\2\2"+
		"\2\b,\3\2\2\2\n;\3\2\2\2\f\u0095\3\2\2\2\16\u00c8\3\2\2\2\20\u00ca\3\2"+
		"\2\2\22\u00cc\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\5\b\5\2\33\3"+
		"\3\2\2\2\34\35\5\6\4\2\35\36\5\b\5\2\36\5\3\2\2\2\37 \5\22\n\2 $\7\3\2"+
		"\2!#\5\20\t\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3"+
		"\2\2\2\'(\7\4\2\2(\7\3\2\2\2)+\5\n\6\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,"+
		"-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\5\f\7\2\60\t\3\2\2\2\61\62\5\20\t\2"+
		"\62\63\7\5\2\2\63\64\5\f\7\2\64<\3\2\2\2\65\66\7\3\2\2\66\67\5\20\t\2"+
		"\678\7\5\2\289\5\f\7\29:\7\4\2\2:<\3\2\2\2;\61\3\2\2\2;\65\3\2\2\2<\13"+
		"\3\2\2\2=>\b\7\1\2>?\7\3\2\2?@\7\13\2\2@A\5\f\7\2AB\7\4\2\2B\u0096\3\2"+
		"\2\2CD\7\3\2\2DE\t\2\2\2EF\5\f\7\2FG\7\4\2\2G\u0096\3\2\2\2HI\t\2\2\2"+
		"I\u0096\5\f\7\34JK\7\3\2\2KL\5\f\7\2LM\7\f\2\2MN\5\f\7\2NO\7\4\2\2O\u0096"+
		"\3\2\2\2PQ\7\3\2\2QR\5\f\7\2RS\7\r\2\2ST\5\f\7\2TU\7\4\2\2U\u0096\3\2"+
		"\2\2VW\7\3\2\2WX\5\f\7\2XY\7\16\2\2YZ\5\f\7\2Z[\7\4\2\2[\u0096\3\2\2\2"+
		"\\]\7\3\2\2]^\5\f\7\2^_\7\17\2\2_`\5\f\7\2`a\7\4\2\2a\u0096\3\2\2\2bc"+
		"\7\3\2\2cd\5\f\7\2de\7\20\2\2ef\5\f\7\2fg\7\4\2\2g\u0096\3\2\2\2hi\7\3"+
		"\2\2ij\5\f\7\2jk\7\6\2\2kl\5\f\7\2lm\7\4\2\2m\u0096\3\2\2\2no\7\3\2\2"+
		"op\7\22\2\2p\u0096\7\4\2\2q\u0096\7\22\2\2rs\7\22\2\2s\u0096\7\22\2\2"+
		"tu\7\3\2\2uv\7\22\2\2vw\7\22\2\2w\u0096\7\4\2\2xy\7\3\2\2yz\t\2\2\2z{"+
		"\5\f\7\2{|\7\4\2\2|\u0096\3\2\2\2}\u0096\5\20\t\2~\177\5\22\n\2\177\u008c"+
		"\7\3\2\2\u0080\u0082\5\20\t\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008d\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0088\7\22\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0089\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\7\4\2\2\u008f\u0096\3\2\2\2\u0090\u0091\7\3\2\2\u0091\u0092\5\f"+
		"\7\2\u0092\u0093\7\4\2\2\u0093\u0096\3\2\2\2\u0094\u0096\7\n\2\2\u0095"+
		"=\3\2\2\2\u0095C\3\2\2\2\u0095H\3\2\2\2\u0095J\3\2\2\2\u0095P\3\2\2\2"+
		"\u0095V\3\2\2\2\u0095\\\3\2\2\2\u0095b\3\2\2\2\u0095h\3\2\2\2\u0095n\3"+
		"\2\2\2\u0095q\3\2\2\2\u0095r\3\2\2\2\u0095t\3\2\2\2\u0095x\3\2\2\2\u0095"+
		"}\3\2\2\2\u0095~\3\2\2\2\u0095\u0090\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\u00c1\3\2\2\2\u0097\u0098\f\25\2\2\u0098\u0099\7\6\2\2\u0099\u00c0\5"+
		"\f\7\26\u009a\u009b\f\24\2\2\u009b\u009c\7\13\2\2\u009c\u00c0\5\f\7\25"+
		"\u009d\u009e\f\23\2\2\u009e\u009f\7\f\2\2\u009f\u00c0\5\f\7\24\u00a0\u00a1"+
		"\f\22\2\2\u00a1\u00a2\7\r\2\2\u00a2\u00c0\5\f\7\23\u00a3\u00a4\f\21\2"+
		"\2\u00a4\u00a5\7\16\2\2\u00a5\u00c0\5\f\7\22\u00a6\u00a7\f\20\2\2\u00a7"+
		"\u00a8\7\17\2\2\u00a8\u00c0\5\f\7\21\u00a9\u00aa\f\17\2\2\u00aa\u00ab"+
		"\7\20\2\2\u00ab\u00c0\5\f\7\20\u00ac\u00ad\f\5\2\2\u00ad\u00ae\7\t\2\2"+
		"\u00ae\u00af\5\f\7\2\u00af\u00b0\7\b\2\2\u00b0\u00b1\5\f\7\2\u00b1\u00b2"+
		"\7\t\2\2\u00b2\u00b3\5\f\7\5\u00b3\u00c0\3\2\2\2\u00b4\u00b5\f\4\2\2\u00b5"+
		"\u00b6\7\t\2\2\u00b6\u00b7\5\f\7\2\u00b7\u00b8\7\b\2\2\u00b8\u00b9\5\f"+
		"\7\4\u00b9\u00c0\3\2\2\2\u00ba\u00bb\f\6\2\2\u00bb\u00bc\7\b\2\2\u00bc"+
		"\u00bd\5\f\7\2\u00bd\u00be\7\t\2\2\u00be\u00c0\3\2\2\2\u00bf\u0097\3\2"+
		"\2\2\u00bf\u009a\3\2\2\2\u00bf\u009d\3\2\2\2\u00bf\u00a0\3\2\2\2\u00bf"+
		"\u00a3\3\2\2\2\u00bf\u00a6\3\2\2\2\u00bf\u00a9\3\2\2\2\u00bf\u00ac\3\2"+
		"\2\2\u00bf\u00b4\3\2\2\2\u00bf\u00ba\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\r\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c4\u00c9\7\4\2\2\u00c5\u00c6\5\f\7\2\u00c6\u00c7\7\4\2\2\u00c7\u00c9"+
		"\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\17\3\2\2\2\u00ca"+
		"\u00cb\7\21\2\2\u00cb\21\3\2\2\2\u00cc\u00cd\7\21\2\2\u00cd\23\3\2\2\2"+
		"\r\27$,;\u0083\u0089\u008c\u0095\u00bf\u00c1\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}