package parser;

import lexer.*;

import java.io.IOException;

public abstract class Exp {

    public static Exp parse(Token token) throws IOException {

        if(token instanceof INTEGER){
            IntLit intL = new IntLit();
            intL.setDigit((INTEGER)token);
            return intL;
        }
        else if(token instanceof LPAR){
            token = SLexer.getToken();
            if(token instanceof INTEGER){
                BinExp binExp = new BinExp();
                // set left
                binExp.setLeftP((INTEGER)token);
                token = SLexer.getToken();
                if(token instanceof OP){
                    // set op in binExp
                    binExp.setOp((OP)token);
                    token = SLexer.getToken();
                    if(token instanceof INTEGER){
                        // set rightP in binExp
                        binExp.setRightP((INTEGER)token);
                        token = SLexer.getToken();
                        if(token instanceof RPAR){
                            return binExp;
                        }
                        else{
                            throw new SyntaxError("Syntax Error");
                        }
                    }
                    else{
                        throw new SyntaxError("Syntax Error");
                    }
                }
                else{
                    throw new SyntaxError("Syntax Error");
                }
            }
            else{
                throw new SyntaxError("Syntax Error");
            }
        }
        else if(token instanceof OP){
            return new BinExp();
        }
        throw new SyntaxError("Syntax Error");
    }


}
