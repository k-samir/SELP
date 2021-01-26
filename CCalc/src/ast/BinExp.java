package ast;

import eval.State;

import java.util.OptionalInt;

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
        return this.leftP.toString() + " " + this.op.toString() + " " + this.rightP.toString();
    }


    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

        int val1 = leftP.eval( integerState,  funDefState);
        int val2 = rightP.eval( integerState,  funDefState);

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

