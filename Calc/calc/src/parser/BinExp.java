package parser;

import eval.State;
import lexer.tokens.Integer;
import lexer.tokens.Op;

import java.io.IOException;

public class BinExp extends Exp {

	private final Op operator;
	private final Exp expression1;
	private final Exp expression2;

	public BinExp(Op operator, Exp expression1, Exp expression2) {
		this.operator = operator;
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	@Override
	public int eval(State<java.lang.Integer> state) throws IOException{
		return switch (this.operator.getValue()) {
			case MINUS      ->  this.expression1.eval(state) -  this.expression2.eval(state);
			case COMPARE    -> (this.expression1.eval(state) == this.expression2.eval(state)) ? 1 : 0;
			case DIVIDE     ->  this.expression1.eval(state) /  this.expression2.eval(state);
			case LESS_THAN  -> (this.expression1.eval(state) <  this.expression2.eval(state)) ? 1 : 0;
			case MULTIPLY   ->  this.expression1.eval(state) *  this.expression2.eval(state);
			case PLUS       ->  this.expression1.eval(state) +  this.expression2.eval(state);
		};
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
		return "BinExp(" + this.operator + "," + this.expression1 + "," + this.expression2 + ")";
	}

}
