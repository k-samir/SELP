package lexer;

import java.io.IOException;
import java.io.InputStream;


public class SLexer {
    private static Lexer lexer;
    private static InputStream in;

    public SLexer(){}
    public static void init(InputStream inp, Lexer l){
        in = inp;
        lexer = l;
    }
    public static Token getToken() throws IOException {
        Token l = lexer.getToken();
        return l;
    }


}
