package lexer.tokens;

public class Identifier implements Token {

	private final String value;

	public Identifier(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IDENTIFIER(" + this.value + ")";
	}

	public String getValue() {
		return value;
	}

}
