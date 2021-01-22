package parser;

import lexer.SLexer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

		SLexer.init(is);
		System.out.println(Exp.parseSimpleExp(SLexer.getToken()));
	}

}
