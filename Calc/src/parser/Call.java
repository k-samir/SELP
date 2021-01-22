package parser;

import eval.State;

public class Call extends Exp{
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
