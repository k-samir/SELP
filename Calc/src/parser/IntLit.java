package parser;

import lexer.INTEGER;

public class IntLit extends Exp{
    private INTEGER digit;

    public INTEGER getDigit() {
        return digit;
    }

    public void setDigit(INTEGER digit) {
        this.digit = digit;
    }

    public String toString() {
        return Integer.toString(digit.getDigit());
    }

    @Override
    public int eval() {
        return digit.getDigit();
    }
}
