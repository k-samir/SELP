package parser;

import eval.State;

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
        return this.leftP.eval(i) + " " + this.centerP.eval(i) + " " + this.rightP.eval(i);
    }

    @Override
    public int eval(State<Integer> i) {


        if(leftP.eval(i) != 0 ) {
            return centerP.eval(i);
        }

        else{
            return rightP.eval(i);
}
    }
}
