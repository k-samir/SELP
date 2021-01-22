package parser;

import eval.State;

import java.io.IOException;

public class IntLit extends Exp {

	private final int value;

	public IntLit(int value) {
		this.value = value;
	}

	@Override
	public int eval(State<Integer> state) {
		return this.value;
	}

	@Override
	public String toString() {
		return "IntLit(" + value + ")";
	}

}
