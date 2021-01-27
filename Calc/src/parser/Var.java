package parser;

import eval.State;
import lexer.IDENTIFIER;

public class Var extends Exp{
    IDENTIFIER s;
    public Var(IDENTIFIER s){
        this.s = s;
    }

    public String getVal() {
        return s.getV();
    }

    @Override
    public String toString() {
        return "VarId(" + this.s + ")";
    }

    @Override
    public int eval(State<Integer> i) {
        return i.lookup(s.getV());
    }
}
