package ast;


import eval.State;

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
        return this.leftP.toString() + " " + this.centerP.toString() + " " + this.rightP.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

        int val1 = leftP.eval(integerState, funDefState);
        int val2 = centerP.eval(integerState, funDefState);
        int val3 = rightP.eval(integerState, funDefState);

        if(val1 != 0){
            return val2;
        }
        else{
            return val3;
        }

    }

    @Override
    public String gen() {
        return this.toString();
    }

}
