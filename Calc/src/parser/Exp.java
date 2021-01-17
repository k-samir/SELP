package parser;

import lexer.*;

import java.io.IOException;

public abstract class Exp extends AST {

    public static Exp parse(Token t) throws IOException {
        if (!(t instanceof LPAR)) {

            return parseSimple(t);
        } else {
            return parseCompoundTail(SLexer.getToken());
        }
    }

    public static Exp parseSimple(Token t) throws IOException {
        if (t instanceof INTEGER) {
            IntLit intL = new IntLit(((INTEGER) t).getDigit());
            //intL.setDigit((INTEGER)t);
            return intL;
        } else if (t instanceof OP) {
            if (t instanceof MINUS) {
                t = SLexer.getToken();
                if (t instanceof INTEGER) {

                    int neg = ((INTEGER) t).getDigit() * -1;

                    IntLit intL = new IntLit(neg);
                    t = SLexer.getToken();

                    return intL;


                } else {
                    throw new SyntaxError("unexpected token");
                }
            } else {
                throw new SyntaxError("unexpected token");
            }
        } else {
            throw new SyntaxError("unexpected token");
        }
    }


    public static Exp parseCompoundTail(Token token) throws IOException {


        // INTEGER
        if (token instanceof OP) {

            // BIN
            BinExp binExp = new BinExp();
            // set left
            binExp.setOp((OP) token);

            token = SLexer.getToken();
            System.out.println(token.toString());
            // OP
            if (token instanceof INTEGER) {
                IntLit intLeft = new IntLit(((INTEGER) token).getDigit());
                binExp.setLeftP(intLeft);
                token = SLexer.getToken();
                // INTEGER

                if (token instanceof INTEGER) {
                    // set rightP in binExp
                    IntLit intR = new IntLit(((INTEGER) token).getDigit());
                    binExp.setRightP(intR);
                    token = SLexer.getToken();

                    // )
                    if (token instanceof RPAR) {
                        return binExp;
                    } else {
                        throw new SyntaxError("Syntax Error");
                    }
                } else if (token instanceof RPAR) {

                    UnExp unexp = new UnExp(binExp.getOp());

                    if (binExp.getOp() instanceof MINUS) {
                        unexp.setExp(binExp.getLeftP());
                        return unexp;
                    } else if (binExp.getOp() instanceof PLUS) {

                        unexp.setExp(binExp.getLeftP());
                        return unexp;
                    } else {
                        throw new SyntaxError("Syntax Error");
                    }
                } else {
                    throw new SyntaxError("Syntax Error");
                }
            } else if (token instanceof LPAR) {

                token = SLexer.getToken();
                if(token instanceof OP){
                    if(token instanceof MINUS){

                        BinExp b = (BinExp) parseCompoundTail(token);
                        IntLit intL = (IntLit) (b.getLeftP());
                        intL.setNDigit(b.getLeftP().eval()*-1);

                        b.setLeftP(intL);

                        IntLit intR = (IntLit) (b.getRightP());
                        intR.setNDigit(b.getRightP().eval()*-1);
                        b.setRightP(intR);

                        System.out.println("  koko " + b.eval());

                        token  = SLexer.getToken();
                        if (token instanceof RPAR) {
                            return b;
                        }
                        else {
                            throw new SyntaxError("Syntax Error");
                        }

                    }
                    else if(token instanceof PLUS){

                        BinExp b = (BinExp) parseCompoundTail(token);
                        token  = SLexer.getToken();
                        if (token instanceof RPAR) {
                            return b;
                        }
                        else {
                            throw new SyntaxError("Syntax Error");
                        }

                    }
                    else {
                        throw new SyntaxError("Syntax Error");
                    }
                }

            } else {
                throw new SyntaxError("Syntax Error");
            }
        } else if (token instanceof IF) {
            token = SLexer.getToken();

            if (token instanceof LPAR) {

                token = SLexer.getToken();
                IntLit intL = (IntLit) getIfArg(token);
                CondExp conExp = new CondExp();
                // set left
                conExp.setLeftP(intL);
                token = SLexer.getToken();

                // INTEGER
                if (token instanceof INTEGER) {
                    IntLit intC = new IntLit(((INTEGER) token).getDigit());
                    conExp.setCenterP(intC);

                    // INTEGER
                    if (token instanceof INTEGER) {
                        IntLit intR = new IntLit(((INTEGER) token).getDigit());
                        conExp.setRightP(intR);

                        token = SLexer.getToken();
                        token = SLexer.getToken();

                        if (token instanceof RPAR) {
                            return conExp;
                        } else {
                            throw new SyntaxError("Syntax Error");
                        }
                        // )
                    } else {
                        throw new SyntaxError("Syntax Error");
                    }
                }
                 else {
                    throw new SyntaxError("Syntax Error");
                }
            }
            else if (token instanceof INTEGER) {

                IntLit intL = new IntLit(((INTEGER) token).getDigit());
                CondExp conExp = new CondExp();
                // set left
                conExp.setLeftP(intL);
                token = SLexer.getToken();

                // INTEGER
                if (token instanceof INTEGER) {
                    IntLit intC = new IntLit(((INTEGER) token).getDigit());
                    conExp.setCenterP(intC);
                    token = SLexer.getToken();

                    // INTEGER
                    if (token instanceof INTEGER) {
                        IntLit intR = new IntLit(((INTEGER) token).getDigit());
                        conExp.setRightP(intR);
                        token = SLexer.getToken();


                        if (token instanceof RPAR) {
                            return conExp;
                        } else {
                            throw new SyntaxError("Syntax Error");
                        }
                        // )
                    } else {
                        throw new SyntaxError("Syntax Error");
                    }
                }
                else {
                    throw new SyntaxError("Syntax Error");
                }
            }

        }


        throw new SyntaxError("Syntax Error");
    }

    public static Exp getIfArg(Token token) throws IOException {

        // CALL IF LPAR FOUND
        IntLit intL;

        if (token instanceof OP) {

            if (token instanceof MINUS) {
                token = SLexer.getToken();
                int neg = ((INTEGER) token).getDigit() * -1;

                intL = new IntLit(neg);

                intL.setNDigit(neg);

                token = SLexer.getToken();

                if (token instanceof RPAR) {

                    return intL;
                } else {
                    throw new SyntaxError("Syntax Error");
                }
            } else if (token instanceof PLUS) {
                token = SLexer.getToken();
                intL = new IntLit(((INTEGER) token).getDigit());
                token = SLexer.getToken();
                if (token instanceof RPAR) {
                    token = SLexer.getToken();
                    return intL;
                } else {
                    throw new SyntaxError("Syntax Error");
                }
            } else {
                throw new SyntaxError("Syntax Error");
            }
        } else if (token instanceof INTEGER) {
            intL = new IntLit(((INTEGER) token).getDigit());
            token = SLexer.getToken();
            if (token instanceof RPAR) {
                token = SLexer.getToken();
                return intL;
            } else {
                throw new SyntaxError("Syntax Error");
            }
        } else {
            throw new SyntaxError("Syntax Error");
        }

    }


    public abstract int eval();
}
