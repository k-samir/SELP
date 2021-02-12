package parser;

import eval.State;
import lexer.tokens.Identifier;

import java.io.IOException;

public class VarId extends Exp {

	private final Identifier id;

	public VarId(final Identifier id) {
		this.id = id;
	}

	@Override
	public int eval(State<Integer> state) throws RuntimeException {
		return state.lookup(id.getValue());
	}

	public String getValue() {
		return this.id.getValue();
	}

	@Override
	public String toString() {
		return "VarId(" + this.id + ")";
	}

}
