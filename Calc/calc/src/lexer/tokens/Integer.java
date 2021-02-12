package lexer.tokens;

public class Integer implements Token {

	private final int value;

	public Integer(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "INTEGER(" + this.value + ")";
	}

	public int getValue() {
		return value;
	}

}
