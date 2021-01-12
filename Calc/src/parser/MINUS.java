package parser;

import lexer.OP;

public class MINUS extends Exp{

    private OP op;

    public MINUS(OP op){
        this.op = op;
    }

    @Override
    public String toString() {
        return this.op.toString();
    }

    @Override
    public int eval() {
        return 0;
    }
}
