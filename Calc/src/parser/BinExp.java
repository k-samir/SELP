package parser;

import lexer.INTEGER;
import lexer.OP;

public class BinExp extends Exp{
    private Exp leftP;
    private OP op;
    private Exp rightP;

    public Exp getLeftP() {
        return leftP;
    }

    public void setLeftP(Exp leftP) {
        this.leftP = leftP;
    }

    public OP getOp() {
        return op;
    }

    public void setOp(OP op) {
        this.op = op;
    }

    public Exp getRightP() {
        return rightP;
    }

    public void setRightP(Exp rightP) {
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.eval() + " " + this.op.getOp() + " " + this.rightP.eval();
    }

    @Override
    public int eval() {

        int val1 = leftP.eval();
        int val2 = rightP.eval();

        switch(op.toString()) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                return 0;

        }




    }

}

