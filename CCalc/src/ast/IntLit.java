package ast;

import eval.State;
import typer.Atom;


import static typer.Atom.*;

public class IntLit extends Exp {
    private final int d;


    public IntLit(int d){
        this.d = d;

    }

    public String toString() {
        return String.valueOf(d);
    }

    @Override
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
        return this.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return d;
    }

    @Override
    public int eval(State<Integer> integerState) {
        return d;
    }

    @Override
    public Atom type() {
        return INT;
    }


}
