package lexer.tokens;

public class Op implements Token {

	private final Value value;

	public Op(Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "OP(" + this.value + ")";
	}

	public Value getValue() {
		return value;
	}

	public enum Value implements Token {

		PLUS("+"),
		MINUS("-"),
		LESS_THAN("<"),
		MULTIPLY("*"),
		DIVIDE("/"),
		COMPARE("==");

		private final String string;

		Value(String string) {
			this.string = string;
		}

		@Override
		public String toString() {
			return this.string;
		}

	}

}
