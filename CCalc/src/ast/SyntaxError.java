package ast;

public class SyntaxError extends RuntimeException {

    public SyntaxError(String s){
        super("Syntax error : " + s);
    }
}
