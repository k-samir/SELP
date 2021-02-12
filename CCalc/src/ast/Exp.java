package ast;

import eval.State;
import typer.Atom;

public abstract class Exp extends AST {
    public abstract String gen();
    public abstract int eval(State<Integer> integerState, State<FuncDef> funDefState);
    public abstract int eval(State<Integer> integerState);
    public abstract Atom type();
}
