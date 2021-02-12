package lexer;

public class OP implements Token{
    String op;
    public OP(String s){
        this.op = s;
    }
    @Override
    public String toString() {
        return this.op;
    }

    public String getOp(){
        return op;
    }
}
