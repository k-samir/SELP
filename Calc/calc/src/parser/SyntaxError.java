package parser;

public class SyntaxError extends RuntimeException {

	private final String message;

	public SyntaxError(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Syntax Error: " + message;
	}

}
