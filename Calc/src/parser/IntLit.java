package parser;

import eval.State;
import lexer.INTEGER;

public class IntLit extends Exp{
    private int d;
    private INTEGER digit;

    public IntLit(int d){
        this.d = d;
        digit = new INTEGER(Integer.toString(d));
    }
    public INTEGER getDigit() {
        return digit;
    }

    public void setDigit(INTEGER digit) {
        this.digit = digit;
    }

    public String toString() {
        return Integer.toString(digit.getDigit());
    }

    public void setNDigit(int d){ this.d = d;}


    @Override
    public int eval(State<Integer> i) {
        return d;
    }

    public int eval(State<Integer> i, State<FunDef> f){
        return d;
    }


}
