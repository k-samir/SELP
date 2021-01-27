package ast;

import eval.State;

public class FunCall extends Exp {


    @Override
    public String gen() {
        return null;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
