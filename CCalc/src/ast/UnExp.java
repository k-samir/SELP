package ast;

import eval.State;

public class UnExp extends Exp {

    int value;
    public UnExp(int value){

        this.value = value;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return value;
    }

    @Override
    public String gen() {
        return this.toString();
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
