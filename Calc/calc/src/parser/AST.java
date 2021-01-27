package parser;

import eval.State;

import java.io.IOException;

public abstract class AST {

	// not used anymore
	// we do not want int eval() in Exp
	// but only void eval() in Exp
	// the method does not return a value, but it increments the state with a new link. This state is passed as a parameter.
	// public abstract int eval();

	public abstract String toString();

}
