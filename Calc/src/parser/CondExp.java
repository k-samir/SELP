package parser;

import eval.State;

import java.io.IOException;

public class CondExp extends Exp{
    private Exp leftP;
    private Exp centerP;
    private Exp rightP;

    public CondExp(Exp leftArg, Exp centerArg, Exp rightArg) {
        this.leftP = leftArg;
        this.centerP = centerArg;
        this.rightP = rightArg;
    }

    public String toString() {
        return this.leftP.toString() + " " + this.centerP.toString() + " " + this.rightP.toString();
    }

    @Override
    public int eval(State<Integer> i) throws IOException {

        if(leftP.eval(i) != 0 ) {
            return centerP.eval(i);
        }

        else{
            return rightP.eval(i);
}
    }
}
