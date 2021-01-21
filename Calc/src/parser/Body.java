package parser;

import eval.State;
import lexer.*;

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
                System.out.println("t1 :" + token );
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
        token = SLexer.getToken();
        return new Body(defs, exp);

    }

    public int eval(State<Integer> in){
        for(VarDef def : varDefs){
            def.eval(in);
        }
         return exp.eval(in);
    }


    @Override
    public String toString() {
        return null;
    }
}
