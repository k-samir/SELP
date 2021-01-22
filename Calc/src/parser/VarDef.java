package parser;

import eval.State;
import lexer.*;

import java.io.IOException;

public class VarDef extends AST{
    private Var var;
    private Exp exp;

    public VarDef(Var var,Exp exp){
        this.var = var;
        this.exp = exp;
    }

    public Var getVar(){
        return var;
    }

    public Exp getExp() {
        return exp;
    }

    public static VarDef parse(Token t) throws IOException {
        if(t instanceof LPAR) {
            Token token = SLexer.getToken();
            if (token instanceof DEFVAR) {
                Token token2  = SLexer.getToken();
                if (token2 instanceof IDENTIFIER){
                    Var var = new Var((IDENTIFIER) token2);
                    Exp exp = Exp.parseSimple(SLexer.getToken());
                    if (SLexer.getToken() instanceof RPAR){
                        return new VarDef(var,exp);
                    }
                }
            }
        }
        throw new SyntaxError(t.toString());
    }

    public void eval(State<Integer> i) throws IOException {
        i.bind(this.var.getVal(),this.exp.eval(i));
    }


    @Override
    public String toString() {
        return "VarDef(" + this.var + "," + this.exp + ")";
    }
}
