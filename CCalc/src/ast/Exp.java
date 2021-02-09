package ast;

import eval.State;
import typer.Type;

public abstract class Exp extends AST {
    public abstract String gen();
    public abstract int eval(State<Integer> integerState, State<FunDef> funDefState);
    public abstract Type type();
}
