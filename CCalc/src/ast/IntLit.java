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
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
        return this.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return d;
    }


}
