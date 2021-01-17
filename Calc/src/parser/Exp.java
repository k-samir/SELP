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

    public static Exp parseSimple(Token t) throws IOException {
        if(t instanceof INTEGER){
                IntLit intL = new IntLit(((INTEGER) t).getDigit());
                //intL.setDigit((INTEGER)t);
                return intL;
        }
        else{
            throw new SyntaxError("unexpected token");
        }
    }


    public static Exp parseCompoundTail(Token token) throws IOException {


            // INTEGER
            if(token instanceof OP){
                // BIN
                BinExp binExp = new BinExp();
                // set left
                binExp.setOp((OP)token);
                token = SLexer.getToken();

                // OP
                if(token instanceof INTEGER){
                    IntLit intLeft = new IntLit(((INTEGER) token).getDigit());
                    binExp.setLeftP(intLeft);
                    token = SLexer.getToken();
                    // INTEGER

                    if(token instanceof INTEGER){
                        // set rightP in binExp
                        IntLit intR = new IntLit(((INTEGER) token).getDigit());
                        binExp.setRightP(intR);
                        token = SLexer.getToken();

                        // )
                        if(token instanceof RPAR){
                            return binExp;
                        }
                        else{
                            throw new SyntaxError("Syntax Error");
                        }
                    }
                    else if(token instanceof RPAR){

                        UnExp unexp = new UnExp(binExp.getOp());

                        if(binExp.getOp() instanceof MINUS){
                            unexp.setExp(binExp.getLeftP());
                            return unexp;
                        }
                        else if(binExp.getOp() instanceof PLUS){

                            unexp.setExp(binExp.getLeftP());
                            return unexp;
                        }
                        else{
                            throw new SyntaxError("Syntax Error");
                        }
                    }
                    else{
                        throw new SyntaxError("Syntax Error");
                    }
                }
                else if(token instanceof LPAR){

                    parseCompoundTail(SLexer.getToken());


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
                    IntLit intL = new IntLit(((INTEGER) token).getDigit());
                    conExp.setLeftP(intL);
                    token = SLexer.getToken();

                    // OP
                    if (token instanceof INTEGER) {
                        IntLit intC = new IntLit(((INTEGER) token).getDigit());
                        conExp.setCenterP(intC);
                        token = SLexer.getToken();

                        // INTEGER
                        if (token instanceof INTEGER) {
                            IntLit intR = new IntLit(((INTEGER) token).getDigit());
                            conExp.setRightP(intR);
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

        throw new SyntaxError("Syntax Error");
    }


    public abstract int eval();
}
