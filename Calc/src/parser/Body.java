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

    public void eval(State<Integer> in, State<FunDef> f){

        for(int i=0;i<varDefs.size();i++){
            varDefs.get(i).eval(in,f);
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
