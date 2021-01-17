package ast;

import ast.AST;

public abstract class Exp extends AST {
    public abstract int eval();
    public abstract String gen();

}
