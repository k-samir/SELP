package parser;

import eval.State;
import lexer.OP;

public class BinExp extends Exp{
    private Exp leftP;
    private OP op;
    private Exp rightP;

    public BinExp(OP op,Exp leftP,Exp rightP){

        this.op = op;
        this.leftP = leftP;
        this.rightP = rightP;
    }

    public BinExp() {

    }

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
        return this.leftP.eval(i) + " " + this.op.getOp() + " " + this.rightP.eval(i);
    }

    @Override
    public int eval(State<Integer> i) {

        int val1 = leftP.eval(i);
        int val2 = rightP.eval(i);

        switch(op.toString()) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            case "==":
                if(val1 == val2){
                    return 1;
                }
                else{
                    return 0;
                }

            default:
                return 0;

        }




    }

}

