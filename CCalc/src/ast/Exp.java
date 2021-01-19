package ast;

import ast.AST;
import eval.State;

import java.util.List;

public abstract class Exp extends AST {
    public abstract String gen();
    protected abstract int eval();

    public abstract int eval(State<Integer> integerState, State<FunDef> funDefState);
}
