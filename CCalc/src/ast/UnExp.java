package ast;

import parser.Exp;

public class UnExp extends Exp {
    OP op;
    Exp exp;

    public UnExp(OP op){
        this.op = op;

    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public int eval() {
        return Integer.parseInt(op.toString() + exp.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.parseInt(op.toString() + exp.toString()));
    }
}
