package parser;

import lexer.INTEGER;
import lexer.OP;

public class CondExp extends Exp{
    private INTEGER leftP;
    private INTEGER centerP;
    private INTEGER rightP;

    public INTEGER getLeftP() {
        return leftP;
    }

    public void setLeftP(INTEGER leftP) {
        this.leftP = leftP;
    }

    public INTEGER getCenterP() {
        return centerP;
    }

    public void setCenterP(INTEGER centerP) {
        this.centerP = centerP;
    }

    public INTEGER getRightP() {
        return rightP;
    }

    public void setRightP(INTEGER rightP) {
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.getDigit() + " " + this.centerP.getDigit() + " " + this.rightP.getDigit();
    }


    @Override
    public int eval() {
        return centerP.getDigit();
    }
}
