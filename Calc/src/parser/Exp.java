package parser;

import lexer.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Exp extends AST {

    public static AST parse(Token t) throws IOException {

        if (!(t instanceof LPAR)) {
            return parseSimple(t);
        }
        else {

            return parseCompoundTail(SLexer.getToken());
        }
    }




    public static AST parseSimple(Token t) throws SyntaxError,IOException {


        if (t instanceof LPAR) {

            AST expression = parseCompoundTail(SLexer.getToken());


            if (expression instanceof FunDef) {
                List<FunDef> funDList = new ArrayList<>();

                while (expression instanceof FunDef) {
                    funDList.add((FunDef) expression);

                    expression = parseCompoundTail(SLexer.getToken());

                    List<VarDef> varList = new ArrayList<>();
                    while (expression instanceof VarDef) {
                        varList.add((VarDef) expression);
                        expression = parseCompoundTail(SLexer.getToken());
                    }

                    if (expression instanceof Exp) {
                        return new Prog(funDList, varList, (Exp) expression);
                    } else {
                        throw new SyntaxError("return expression");
                    }
                }
                return expression;
            }
            else if(expression instanceof BinExp){
                return expression;
            }
            else if(expression instanceof CondExp){
                return expression;
            }
            else {
                throw new SyntaxError("return expression");
            }
        }
        else if (t instanceof INTEGER) {
            IntLit intL = new IntLit(((INTEGER) t).getDigit());
            //intL.setDigit((INTEGER)t);

            return intL;
        }

        else {

            return parseCompoundTail(SLexer.getToken());
        }
    }



    public static Exp parseSimple2(Token t) throws IOException {
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

    public static OP parseOP(Token t){
        switch(t.toString()){
            case "-":
                return new MINUS("-");
            case "+":
                return new PLUS("+");
            case "/":
                return new DIVIDE("/");
            case "*":
                return new TIMES("*");
            case "==":
                return new EQUAL("==");

            default:
                throw new SyntaxError("parse op ");

        }

    }

    public static Exp parseCompoundTail(Token token) throws IOException {

        if (token instanceof OP) {

            OP op = parseOP((OP) token);

            if (!(op instanceof MINUS) ) {

               if(op instanceof EQUAL){
                   token = SLexer.getToken();
               }

                token = SLexer.getToken();


                Exp leftArg;

                leftArg = (Exp)parseSimple(token);


                token = SLexer.getToken();

                if(token instanceof RPAR){


                    int neg = (leftArg).eval();

                    IntLit intL = new IntLit(neg);
                    token = SLexer.getToken();

                    if (token instanceof EOF) {
                        return intL;
                    }
                    else {
                        // GESTION VARIABLE ICI et MULTIPLE DEF
                        System.out.println(token.getClass());

                        throw new SyntaxError(") missing");
                    }
                }

                Exp rightArg = (Exp) parseSimple(token);


                token = SLexer.getToken();

                if (token instanceof RPAR) {
                    return new BinExp(op, leftArg, rightArg);
                } else {
                    throw new SyntaxError(") missing");
                }
            }
            else {

                token = SLexer.getToken();
                 if(!(token instanceof LPAR)) {


                     Exp leftArg = (Exp) parseSimple(token);
                     token = SLexer.getToken();

                     if(token instanceof RPAR){

                         int neg = (leftArg).eval() * -1;
                         IntLit intL = new IntLit(neg);

                         return intL;

                     }
                     else {
                         Exp rightArg = (Exp) parseSimple(token);

                         token = SLexer.getToken();

                         if (token instanceof RPAR) {


                             return new BinExp(op,leftArg, rightArg);
                         } else {
                             throw new SyntaxError(") missing");
                         }

                     }
                 }

                 else if(token instanceof LPAR){

                     token = SLexer.getToken();

                     Exp e = parseCompoundTail(token);


                     UnExp unEx = new UnExp(e);
                    unEx.setOp(op);

                     return unEx;

                 }
                 else{
                     throw new SyntaxError(") missing");
                 }
            }
        }
        else if(token instanceof IF){

            token = SLexer.getToken();
            Exp leftArg;
            if(token instanceof LPAR){
                token = SLexer.getToken();
               leftArg = (Exp) parseCompoundTail(token);

            }
            else{
                leftArg = (Exp) parse(token);
            }

            token = SLexer.getToken();
            Exp centerArg = (Exp) parse(token);


            token = SLexer.getToken();
            Exp rightArg = (Exp) parse(token);


           token = SLexer.getToken();
            if (token instanceof RPAR) {

                return new CondExp(leftArg,centerArg, rightArg);
            }
            else {
                throw new SyntaxError(") missing");
            }
        }

         else{
            System.out.println(token);
            throw new SyntaxError(") missing");
        }
    }


    public static Exp parseCompoundTail2(Token token) throws IOException {


        // INTEGER
        if (token instanceof OP) {

            // BIN
            BinExp binExp = new BinExp();
            // set left
            binExp.setOp((OP) token);

            token = SLexer.getToken();

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
