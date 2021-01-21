package parser;

import eval.State;

public class Var extends Exp{
    String s;
    public Var(String s){
        this.s = s;
    }
    @Override
    public String toString() {
        return null;
    }

    public int eval(State<Integer> i, State<FunDef> f){
        return 0;
    }


    @Override
    public int eval(State<Integer> i) {
        return 0;
    }
}
