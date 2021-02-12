package lexer;

import lexer.tokens.Token;

import java.io.IOException;
import java.io.InputStream;

public class SLexer {

	private static Lexer lexer;

	public static void init(final InputStream stream) throws IOException {
		lexer = new Lexer(stream);
	}

	public static Token getToken() throws IOException {
		return lexer.getToken();
	}

}
