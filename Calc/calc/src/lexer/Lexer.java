package lexer;

import lexer.tokens.Integer;
import lexer.tokens.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
	private final InputStream in;
	private int i; // current ASCII character (coded as an integer)

	public Lexer(InputStream in) throws IOException {
		this.in = in;
		next(); // get first character
	}

	// helper method: read next character
	private void next() throws IOException {
		i = in.read();
	}

	public List<Token> lex() throws IOException {
		// return the list of tokens recorded in the file
		List<Token> tokens = new ArrayList<>();

		try {
			Token token = getToken();

			while (!(token instanceof EOF)) {
				tokens.add(token);
				token = getToken();
			}
			tokens.add(token); // this is the EOF token
		} catch (IOException e) {
			in.close(); // close the reader
			throw e; // pass the exception up the stack
		}
		return tokens;
	}

	Token getToken() throws IOException {
		switch (i) {
			case -1 -> {
				in.close();
				return new EOF();
			}
			case '(' -> {
				next();
				return new LPar();
			}
			case ')' -> {
				next();
				return new RPar();
			}
			case '=' -> {
				next();
				if (i == '=') {
					next();
					return new Op(Op.Value.COMPARE);
				}
				return new DefVar();
			}
			case '+' -> {
				next();
				return new Op(Op.Value.PLUS);
			}
			case '-' -> {
				next();
				return new Op(Op.Value.MINUS);
			}
			case '*' -> {
				next();
				return new Op(Op.Value.MULTIPLY);
			}
			case '/' -> {
				next();
				return new Op(Op.Value.DIVIDE);
			}
			case '<' -> {
				next();
				return new Op(Op.Value.LESS_THAN);
			}
			case ' ', '\n', '\t', '\r' -> {
				next();
				return getToken();
			}
			case '0' -> {
				next();
				return new Integer(0);
			}
			case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
				int value = charToDigit(i);
				next();
				while ('0' <= i && i <= '9') {
					value *= 10;
					value += charToDigit(i);
					next();
				}
				return new Integer(value);
			}
			case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' -> {
				StringBuilder label = new StringBuilder(Character.toString((char) i));
				next();
				while (('a' <= i && i <= 'z') || (i >= '0' && i <= '9')) {
					label.append((char) i);
					next();
				}
				if (label.toString().equals("if")) {
					return new If();
				} else if (label.toString().equals("defun")) {
					return new Defun();
				}
				return new Identifier(label.toString());
			}
			default -> throw new LexicalError(i);
		}
	}

	private int charToDigit(int c) {
		return c - '0';
	}

}
