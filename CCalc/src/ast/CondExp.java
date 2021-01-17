package ast;


import parser.Exp;

public class CondExp extends Exp {
    private Exp leftP;
    private Exp centerP;
    private Exp rightP;

    public CondExp(Exp leftP,Exp centerP, Exp rightP){
        this.leftP = leftP;
        this.centerP = centerP;
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.eval() + " " + this.centerP.eval() + " " + this.rightP.eval();
    }

    @Override
    public int eval() {

        int val1 = leftP.eval();
        int val2 = centerP.eval();
        int val3 = rightP.eval();

        if(val1 != 0){
            return val2;
        }
        else{
            return val3;
        }

    }
}
