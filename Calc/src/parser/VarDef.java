package parser;

import eval.State;
import lexer.Token;

public class VarDef extends AST{

    String str;
    Exp exp;

    public static VarDef parse(Token t){
        return new VarDef();
    }

    public void eval(State<Integer> i, State<FunDef> f){

    }


    @Override
    public String toString() {
        return null;
    }
}
