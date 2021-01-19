package ast;

import eval.State;

public class IntLit extends Exp {
    private int d;


    public IntLit(int d){
        this.d = d;

    }

    public String toString() {
        return String.valueOf(d);
    }

    @Override
    public int eval() {
        return d;
    }

    @Override
    public String gen() {
        return null;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return 0;
    }


}
