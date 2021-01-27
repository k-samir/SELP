package parser;

import eval.State;
import lexer.SLexer;
import lexer.tokens.*;

import java.io.IOException;
import java.lang.Integer;

public class VarDef extends AST {

	private final VarId varId;
	private final Exp expression;

	public VarDef(VarId varId, Exp expression) {
		this.varId = varId;
		this.expression = expression;
	}

	public VarId getVarId() {
		return varId;
	}

	public Exp getExpression() {
		return expression;
	}

	public static VarDef parse(final Token token) throws IOException {
		if (token instanceof LPar) {
			Token next1 = SLexer.getToken();

			if (next1 instanceof DefVar) {
				return parseVarDefTail(SLexer.getToken());
			}
		}

		throw new SyntaxError(token.toString());
	}

	public static VarDef parseVarDefTail(Token token) throws IOException {
		if (token instanceof Identifier) {
			VarId varId = new VarId((Identifier) token);
			Exp expression = Exp.parseSimpleExp(SLexer.getToken());

			if (SLexer.getToken() instanceof RPar) {
				return new VarDef(varId, expression);
			}
		}

		throw new SyntaxError(token.toString());
	}

	public void eval(State<Integer> state) throws IOException {
		state.bind(this.varId.getValue(), this.expression.eval(state));
	}

	@Override
	public String toString() {
		return "VarDef(" + this.varId + "," + this.expression + ")";
	}

}
