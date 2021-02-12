package parser;

import lexer.DEFVAR;
import lexer.LPAR;
import lexer.SLexer;
import lexer.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prog extends AST{

    List<FunDef> funDefs;
    Body body;

    public Prog(List<FunDef> funDList, List<VarDef> varList, Exp expression) {
        super();
    }

    public Prog(List<FunDef> funDefs, Body body) {
        super();
        this.funDefs = funDefs;
        this.body = body;
    }

    public static Prog parse(Token token, List<FunDef> funDefs) throws IOException {
        if (token instanceof LPAR) {
            Token token2 = SLexer.getToken();
            if (token2 instanceof DEFVAR) { // this is a definition
                // parse tail of definition
                FunDef def = FunDef.parse(token2);
                // accumulate definition
                funDefs.add(def);
                // loop on the rest of the body with the accumulated definitions
                // System.out.println("t1 :" + token );
                return parse(SLexer.getToken(), funDefs);
            } else { // there is a compound expression after the definitions
                ArrayList ar = new ArrayList<>();
                Body body = Body.parse(token2,ar);
                return new Prog(funDefs, body);
            }
        } else // there is a simple expression at the end of a simple body
            return parseSimpleProg(token, funDefs);
    }

    private static Prog parseSimpleProg(Token token, List<FunDef> funDefs) throws IOException {
        ArrayList ar = new ArrayList<>();
        Body body =  Body.parseSimpleBody(token,ar);
        SLexer.getToken();
        return new Prog(funDefs, body);
    }


    public int eval(){
        return 0;
    }
    @Override
    public String toString() {
        return null;
    }
}
