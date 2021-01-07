package lexer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private InputStream in;
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

    private String getDigit() throws IOException {

            String x = "-2";
            int j = 0;
            while (j < 10) {
                if (Character.getNumericValue(i) == j) {
                    x = Integer.toString(j);
                    break;

                }
                j++;
            }

            if (x != "-2") {
                this.next();
                if (Character.getNumericValue(i) < 10) {
                    String temp = getDigit();
                    if(temp != "-2") {
                        x = x + temp;
                    }
                }

            }
        return x;
    }

    private Token getToken() throws IOException {

        switch (i) {
            case ' ':
                next();
                return new SPACE();
            case -1:
                in.close();
                return new EOF();

            case '(':
                next();
                return new LPAR();
            case ')':
                next();
                return new RPAR();
            case '=':
                next();
                if (getToken() instanceof DEFVAR) {
                    return new OP("==");
                } else {
                    return new DEFVAR();
                }

            case '+':
            case '*':
            case '/':
            case '<':

                return new OP(Character.toString(i));



            default:

                if (Character.getNumericValue(i) < 10 && Character.getNumericValue(i) > -1) {
                    return new INTEGER(getDigit());
                } else {
                    throw new LexicalError(i);
                }
        }
    }
}


