package parser;

import lexer.Token;

public class FunDef extends AST{

    public static FunDef parse(Token t){
        return new FunDef();
    }


    @Override
    public String toString() {
        return null;
    }
}
