package parser;

import eval.State;

import java.io.IOException;

public class CondExp extends Exp {

	private final Exp expression1;
	private final Exp expression2;
	private final Exp expression3;

	public CondExp(Exp expression1, Exp expression2, Exp expression3) {
		this.expression1 = expression1;
		this.expression2 = expression2;
		this.expression3 = expression3;
	}

	@Override
	public int eval(State<Integer> state) throws IOException {
		if (this.expression1.eval(state) != 0) {
			return this.expression2.eval(state);
		} else {
			return this.expression3.eval(state);
		}
	}

	@Override
	public String toString() {
		return "CondExp(" + this.expression1 + "," + this.expression2 + "," + this.expression3 + ")";
	}

}
