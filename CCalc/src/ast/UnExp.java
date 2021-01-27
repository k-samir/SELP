package ast;

import eval.State;

public class UnExp extends Exp {
    OP op;
    Exp exp;

    public UnExp(Exp exp){
        this.exp = exp;

    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return Integer.parseInt(op.toString() + exp.toString());
    }

    @Override
    public String gen() {
        return null;
    }


    @Override
    public String toString() {
        return String.valueOf(Integer.parseInt(op.toString() + exp.toString()));
    }
}
