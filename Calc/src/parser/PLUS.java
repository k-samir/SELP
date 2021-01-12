package parser;

import lexer.OP;

public class PLUS extends Exp{

    private OP op;

    public PLUS(OP op){
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
