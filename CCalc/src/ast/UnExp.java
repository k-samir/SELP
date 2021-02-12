package ast;

import eval.State;
import typer.Atom;

public class UnExp extends Exp {

    int value;
    public UnExp(int value){

        this.value = value;
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return value;
    }

    @Override
    public int eval(State<Integer> integerState) {
        return value;
    }


    @Override
    public Atom type() {
        return Atom.INT;
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
    public String toString() {
        return String.valueOf(value);
    }
}
