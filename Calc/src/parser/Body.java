package parser;

import eval.State;
import lexer.Token;

import java.util.List;

public class Body extends AST{

    List<VarDef> varDefs;
    Exp exp;

    public static Body parse(Token t, List<VarDef> varDefs){
        return new Body();
    }

    public int eval(State<Integer> i, State<FunDef> f){
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
