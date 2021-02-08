package ast;

import ast.AST;
import eval.State;
import typer.Sig;
import typer.Type;

import java.util.List;

public abstract class Exp extends AST {
    public abstract String gen();
    public abstract int eval(State<Integer> integerState, State<FunDef> funDefState);
    //public abstract Type type(State<Type> stVar, State<Sig> stFun);
    public abstract Type type();
}
