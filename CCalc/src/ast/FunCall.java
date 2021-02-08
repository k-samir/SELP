package ast;

import eval.State;
import typer.Sig;
import typer.Type;

public class FunCall extends Exp {


    @Override
    public String gen() {
        return null;
    }

    @Override
    public String gen(int i) {
        return null;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return 0;
    }

    @Override
    public Type type() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }


}
