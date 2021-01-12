package parser;

import lexer.INTEGER;
import lexer.OP;

public class BinExp extends Exp{
    private INTEGER leftP;
    private OP op;
    private INTEGER rightP;

    public INTEGER getLeftP() {
        return leftP;
    }

    public void setLeftP(INTEGER leftP) {
        this.leftP = leftP;
    }

    public OP getOp() {
        return op;
    }

    public void setOp(OP op) {
        this.op = op;
    }

    public INTEGER getRightP() {
        return rightP;
    }

    public void setRightP(INTEGER rightP) {
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.getDigit() + " " + this.op.getOp() + " " + this.rightP.getDigit();
    }

    @Override
    public int eval() {
        if(op.toString().equals("-")){
            return leftP.getDigit() - rightP.getDigit();
        }
        else if(op.toString().equals("+")){
            return leftP.getDigit() + rightP.getDigit();
        }
        else if(op.toString().equals("/")){
            return leftP.getDigit() / rightP.getDigit();
        }
        else {return 0; }

    }

}

