package parser;

import eval.State;
import lexer.OP;

public class UnExp extends Exp{
    OP op;
    Exp exp;

    public UnExp(Exp exp){
        this.exp = exp;

    }

    public UnExp(OP op){
        this.op = op;

    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public int eval(State<Integer> i) {
        switch(op.toString()) {
            case "+":
                return exp.eval(i);
            case "-":
                return -1 * exp.eval(i);

            default:
                return 0;

        }

    }

    public void setOp(OP op){
        this.op = op;
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.parseInt(op.toString() + exp.toString()));
    }
}
