package parser;

import lexer.INTEGER;
import lexer.OP;

public class CondExp extends Exp{
    private Exp leftP;
    private Exp centerP;
    private Exp rightP;

    public Exp getLeftP() {
        return leftP;
    }

    public void setLeftP(Exp leftP) {
        this.leftP = leftP;
    }

    public Exp getCenterP() {
        return centerP;
    }

    public void setCenterP(Exp centerP) {
        this.centerP = centerP;
    }

    public Exp getRightP() {
        return rightP;
    }

    public void setRightP(Exp rightP) {
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.eval() + " " + this.centerP.eval() + " " + this.rightP.eval();
    }

    @Override
    public int eval() {
        return centerP.eval();
    }
}
