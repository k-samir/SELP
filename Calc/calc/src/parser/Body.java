package parser;

import eval.State;
import lexer.SLexer;
import lexer.tokens.*;

import java.io.IOException;
import java.lang.Integer;
import java.util.List;

public class Body extends AST {

	private final List<VarDef> varDefs;
	private final Exp expression;

	public Body(Exp expression, List<VarDef> varDefs) {
		this.varDefs = varDefs;
		this.expression = expression;
	}

	public static Body parse(final Token token, final List<VarDef> definedVars) throws IOException {
		if (token instanceof LPar) {
			final Token next = SLexer.getToken();
			if (next instanceof DefVar) {
				final VarDef varDef = VarDef.parseVarDefTail(SLexer.getToken());
				definedVars.add(varDef);
				return parse(SLexer.getToken(), definedVars);
			} else {
				final Exp exp = Exp.parseCompositeExpTail(next);
				return new Body(exp, definedVars);
			}
		} else {
			return parseSimpleBody(token, definedVars);
		}
	}

	private static Body parseSimpleBody(Token token, List<VarDef> definedVars) throws IOException {
		final Exp expression = Exp.parseSimpleExp(token);
		return new Body(expression, definedVars);
	}

	public int eval(State<Integer> state) throws IOException {
		// return this.expression.eval(new State<>());
		for (VarDef vd: varDefs){
			vd.eval(state);
		}
		return this.expression.eval(state);
	}

	@Override
	public String toString() {
		StringBuilder varDef = new StringBuilder();
		for (VarDef v : this.varDefs){
			varDef.append(v.toString());
		}
		return "Body(" + varDef + "," + this.expression + ")";
	}

}
