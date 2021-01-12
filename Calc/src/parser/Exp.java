package parser;

import lexer.*;

import java.io.IOException;

public abstract class Exp extends AST {

    public static Exp parse(Token t) throws IOException{
        if(!(t instanceof LPAR)){
            return parseSimple(t);
        }
        else{
            return parseCompoundTail(SLexer.getToken());
        }
    }

    public static Exp parseSimple(Token t){
        if(t instanceof INTEGER){
                IntLit intL = new IntLit();
                intL.setDigit((INTEGER)t);
                return intL;
        }
        else{
            throw new SyntaxError("unexpected token");
        }
    }


    public static Exp parseCompoundTail(Token token) throws IOException {


            // INTEGER
            if(token instanceof INTEGER){
                BinExp binExp = new BinExp();
                // set left
                binExp.setLeftP((INTEGER)token);
                token = SLexer.getToken();

                // OP
                if(token instanceof OP){
                    // set op in binExp
                    binExp.setOp((OP)token);
                    token = SLexer.getToken();

                    // INTEGER
                    if(token instanceof INTEGER){
                        // set rightP in binExp
                        binExp.setRightP((INTEGER)token);
                        token = SLexer.getToken();

                        // )
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

            else if(token instanceof IF){
                token = SLexer.getToken();
                if(token instanceof INTEGER) {
                    CondExp conExp = new CondExp();
                    // set left
                    conExp.setLeftP((INTEGER) token);
                    token = SLexer.getToken();

                    // OP

                    if (token instanceof OP) {
                        conExp.setOp((OP) token);
                        token = SLexer.getToken();

                        if(token instanceof DEFVAR){
                            token = SLexer.getToken();
                        }

                        // INTEGER
                        if (token instanceof INTEGER) {

                            conExp.setRightP((INTEGER) token);
                            token = SLexer.getToken();

                            // )
                            if (token instanceof RPAR) {
                                return conExp;
                            } else {
                                throw new SyntaxError("Syntax Error");
                            }
                        } else {
                            throw new SyntaxError("Syntax Error");
                        }
                    } else {
                        throw new SyntaxError("Syntax Error");
                    }

                }

            }
        // OP
        else if(token instanceof OP){
            return new PLUS((OP)token);
        }
        throw new SyntaxError("Syntax Error");
    }


    public abstract int eval();
}
