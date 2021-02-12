package calc;

import eval.State;
import lexer.SLexer;
import lexer.tokens.EOF;
import parser.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Calc {

	/**
	 * @param args - arg[0] is the filename of the file to analyze,
	 *             otherwise, the program is entered at the console.
	 *             IMPORTANT REQUIREMENT: the errors are propagated up the stack.
	 */
	public static void main(String[] args) throws IOException {
		InputStream is;
		String filename;

		switch (args.length) {
			case 0 -> is = System.in;
			case 1 -> {
				filename = args[0];
				is = new FileInputStream(filename);
			}
			default -> throw new IllegalArgumentException();
		}

		/*Lexer lexer = new Lexer(is);
		tokens = lexer.lex();
		// output result
		System.out.println("Found " + tokens.size() + " token(s)");
		System.out.println(tokens);*/
		System.out.println(" ==> " + interpret(is));
	}

	public static int interpret(InputStream is) throws IOException, SyntaxError {
		SLexer.init(is);
		// The only difference is that we evaluate a body rather than an expression.
		//Exp exp = Exp.parse(SLexer.getToken());
		Body body = Body.parse(SLexer.getToken(), new ArrayList<>());

		/*try {
			Token token = SLexer.getToken();
			Exp.parse(token);
			throw new SyntaxError(token.toString());
		} catch (IOException ignored) {}*/

		if (!(SLexer.getToken() instanceof EOF)) {
			throw new SyntaxError("Not at End Of File");
		}

		System.out.println(body);
		return body.eval(new State<>());
	}

}
