package ast;

import calc.State;

public class BinExp extends Exp {
    private Exp leftP;
    private OP op;
    private Exp rightP;

    public BinExp(OP op, Exp leftP,Exp rightP){
        this.op =  op;
        this.leftP = leftP;
        this.rightP = rightP;
    }


    public OP getOp() {
        return op;
    }

    public void setOp(OP op) {
        this.op = op;
    }


    public String toString() {
        return this.leftP.eval() + " " + this.op.toString() + " " + this.rightP.eval();
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

    @Override
    public String gen() {
        return null;
    }



}

