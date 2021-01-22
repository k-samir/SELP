package parser;

import eval.State;

public class IntLit extends Exp{
    private int d;

    public IntLit(int d){
        this.d = d;
    }

    public String toString() {
        return "IntLit(" + d + ")";
    }

    @Override
    public int eval(State<Integer> i) {
        return d;
    }

}
