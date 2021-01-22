package parser;

import lexer.Token;

import java.util.List;

public class Prog extends AST{
    List<FunDef> funDefs;
    Body body;

    public Prog(List<FunDef> funDList, List<VarDef> varList, Exp expression) {
        super();
    }

   /* public static Prog parse(Token t){
        return this;
    }*/

    public int eval(){
        return 0;
    }
    @Override
    public String toString() {
        return null;
    }
}
