package parser;

import eval.State;
import lexer.IDENTIFIER;

public class Fun extends Exp{
    IDENTIFIER s;
    public Fun(IDENTIFIER s){
        this.s = s;
    }

    public String getVal() {
        return s.getV();
    }

    @Override
    public String toString() {
        return "FunId(" + this.s + ")";
    }

    @Override
    public int eval(State<Integer> i) {
        return i.lookup(s.getV());
    }
}
