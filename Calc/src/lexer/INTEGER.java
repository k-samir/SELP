package lexer;

public class INTEGER implements Token {
    String digit;
    public INTEGER(String digit){
        this.digit = digit;
    }
    @Override
    public String toString() {
        return "INTEGER:" + this.digit;
    }
}
