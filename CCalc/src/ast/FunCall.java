package ast;

import eval.State;
import typer.Atom;

public class FunCall extends Exp {
    String nom;


    public FunCall(String nom){
        this.nom = nom;
    }

    @Override
    public String gen() {
        return null;
    }

    @Override
    public String gen(int i) {
        return null;
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return 0;
    }

    @Override
    public Atom type() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
