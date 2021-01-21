package parser;

import eval.State;
import lexer.DEFVAR;
import lexer.LPAR;
import lexer.SLexer;
import lexer.Token;

import java.io.IOException;
import java.util.List;

public class Body extends AST{

    List<VarDef> varDefs;
    Exp exp;

    public Body( List<VarDef> varD, Exp exp){
        this.varDefs = varD;
        this.exp = exp;
    }

    public static Body parse(Token token, List<VarDef> defs) throws IOException {
        if (token instanceof LPAR) {
            Token token2 = SLexer.getToken();
            if (token2 instanceof DEFVAR) { // this is a definition
                // parse tail of definition
                VarDef def = VarDef.parse(SLexer.getToken());
                // accumulate definition
                defs.add(def);
                // loop on the rest of the body with the accumulated definitions
                return parse(SLexer.getToken(), defs);
            } else { // there is a compound expression after the definitions
                Exp exp = Exp.parseCompoundTail(token2);

                return new Body(defs, exp);
            }
        } else // there is a simple expression at the end of a simple body
            return parseSimpleBody(token, defs);
    }

    public static Body parseSimpleBody(Token token, List<VarDef> defs) throws IOException {
        Exp exp =  Exp.parseSimple(token);
        return new Body(defs, exp);
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
