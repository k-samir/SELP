package parser;

import eval.State;
import lexer.*;

import java.io.IOException;

public class VarDef extends AST{

    String str;
    Exp exp;

    public VarDef(String str,Exp exp){
        this.str = str;
        this.exp = exp;
    }
    public static VarDef parse(Token t) throws IOException {
        String str = null;

        if(t instanceof IDENTIFIER){
            str = t.toString();
            t = SLexer.getToken();
            Exp exp = Exp.parse(t);
            t = SLexer.getToken();
            System.out.println(t);
           if(t instanceof RPAR){
               return new VarDef(str,exp);
           }


            throw new SyntaxError("error vardef");

    }
        else{throw new SyntaxError("error vardef");}}

    public void eval(State<Integer> i){
        i.bind(this.str,this.exp.eval(i));
    }


    @Override
    public String toString() {
        return exp.toString();
    }
}
