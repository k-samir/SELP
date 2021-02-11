package ast;

import eval.State;
import typer.Atom;

import static typer.Atom.*;

public abstract class Exp extends AST {
    public abstract String gen();
    public abstract int eval(State<Integer> integerState, State<FunDef> funDefState);
    public abstract Atom type();
}
