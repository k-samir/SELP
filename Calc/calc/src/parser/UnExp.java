package parser;

import eval.State;
import lexer.tokens.Op;

import java.io.IOException;

public class UnExp extends Exp {

	private final Exp expression;

	public UnExp(Exp expression) {
		this.expression = expression;
	}

	@Override
	public int eval(State<Integer> state) throws IOException {
		return -this.expression.eval(state);
	}

	/**
	 * BinExp(MINUS,
	 * BinExp(TIMES,
	 * Var("b"),
	 * Var("b")),
	 * BinExp(TIMES,
	 * IntLit(4),
	 * BinExp(TIMES,
	 * Var("a"),
	 * Var("c"))))
	 *
	 * @return Représentation textuelle de l'arbre syntaxique
	 */
	@Override
	public String toString() {
		return "UnExp(" + this.expression + ")";
	}

}
