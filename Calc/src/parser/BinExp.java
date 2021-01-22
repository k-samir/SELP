package parser;

import eval.State;
import lexer.OP;

import java.io.IOException;

public class BinExp extends Exp{
    private Exp leftP;
    private OP op;
    private Exp rightP;

    public BinExp(OP op,Exp leftP,Exp rightP){

        this.op = op;
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
        return "BinExp(" + this.leftP.toString() + " " + this.op.getOp() + " " + this.rightP.toString() + ")";
    }

    @Override
    public int eval(State<Integer> i) throws IOException {

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

