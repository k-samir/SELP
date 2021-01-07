package lexer;

public class IDENTIFIER implements  Token{
    private String v;
    public IDENTIFIER(String s){
        this.v = s;
    }
    @Override
    public String toString(){
        return "IDENTIFIER:" + this.v;
    }
}
