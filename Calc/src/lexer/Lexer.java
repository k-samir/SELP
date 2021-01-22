package lexer;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    private String getDigit(Boolean bool) throws IOException {
        String x = "-2";
        int j = 0;
        while (j < 10) {
            if (Character.getNumericValue(i) == j) {
                x = Integer.toString(j);
                break;

            }
            j++;
        }

        if (bool){
            if (Character.getNumericValue(i)==0){
                this.next();
                return Integer.toString(0);
            }
        }

        if (x != "-2") {
            this.next();
            if (Character.getNumericValue(i) < 10) {
                String temp = getDigit(false);
                if (temp != "-2") {
                    x = x + temp;
                }
            }

        }
        return x;
    }

    private boolean matchIdentifier() {
        char caractere = (char)i;
        if (caractere >= 'a' && caractere <= 'z') {
            return true;
        }

        if (caractere >= '0' && caractere <= '9') {
            return true;
        }

        return false;

    }

    private boolean checkComp() throws IOException {

        if (i == '=') {
            return true;
        }
        else {
            return false;
        }
    }

    public Token getToken() throws IOException {

        switch (i) {

            case ' ':
            case '\n':
            case '\r':
            case '\t':
                next();
                return getToken();

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
                if(checkComp()){

                    return new COMP();
                }
                else{
                    return new DEFVAR();
                }


            case '+':
                int temp = i;
                next();
                return new PLUS(Character.toString(temp));

            case '*':
                int temp2 = i;
                next();
                return new TIMES(Character.toString(temp2));
            case '-':
                int temp3 = i;
                next();
                return new MINUS(Character.toString(temp3));

            case '/':
            case '<':
                int temp4 = i;
                next();
                return new OP(Character.toString(temp4));

            default:

                if (Character.getNumericValue(i) < 10 && Character.getNumericValue(i) > -1) {
                    return new INTEGER(getDigit(true));
                }
                else if ('a' <= i && i <= 'z') {
                    String identifier = "";
                    while (matchIdentifier()) {
                        char c = (char) i;
                        identifier += Character.toString(c);
                        next();
                    }
                    if(identifier.equals("if")){
                        return new IF();
                    }

                    else if(identifier.equals("defun")){return new DEFUN();}
                        return new IDENTIFIER(identifier);
                }

                else {
                    throw new LexicalError(i);
                }
        }
    }
}



