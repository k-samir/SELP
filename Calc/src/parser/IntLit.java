package parser;

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
    public void setNDigit(int d){ digit.setDigit(d);}

    @Override
    public int eval() {
        return digit.getDigit();
    }


}
