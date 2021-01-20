package parser;

import lexer.INTEGER;
import lexer.OP;

public class CondExp extends Exp{
    private Exp leftP;
    private Exp centerP;
    private Exp rightP;

    public CondExp(Exp leftArg, Exp centerArg, Exp rightArg) {
        this.leftP = leftArg;
        this.centerP = centerArg;
        this.rightP = rightArg;
    }

    public CondExp() {

    }

    public void setLeftP(Exp leftP) {
        this.leftP = leftP;
    }
    public void setCenterP(Exp centerP) {
        this.centerP = centerP;
    }
    public void setRightP(Exp rightP) {
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.eval() + " " + this.centerP.eval() + " " + this.rightP.eval();
    }

    @Override
    public int eval() {


        if(leftP.eval() != 0 ) {
            return centerP.eval();
        }

        else{
            return rightP.eval();
}
    }
}
