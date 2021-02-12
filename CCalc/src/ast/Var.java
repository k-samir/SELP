package ast;

import eval.State;
import typer.Atom;

public class Var extends Exp{

    String s;
    public Var(String s){
        this.s = s;
    }

    @Override
    public String toString(){
        return s;
    }
    @Override
    public String gen(int i) {
        return s;
    }

    @Override
    public String gen() {
        return s;
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return 0;
    }

    @Override
    public Atom type() {
        return null;
    }
}
