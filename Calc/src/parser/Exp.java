package parser;

import eval.State;
import lexer.*;

import java.io.IOException;

public abstract class Exp extends AST {

    public static Exp parse(Token t) throws IOException {
        if (!(t instanceof LPAR)) {
            return  parseSimple(t);
        } else {

            return parseCompoundTail(SLexer.getToken());
        }
       /* if (t instanceof LPAR) {

            AST expression = parseCompoundTail(SLexer.getToken());

            // red
            /*if (expression instanceof FunDef) {
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
            else{
                return expression;
            }*/
/*
        }
        else{
            return parseSimple(t);
        }*/
           /* if (!(t instanceof LPAR)) {
                return  parseSimple(t);
            } else {

                return parseCompoundTail(SLexer.getToken());
            }*/

    }

    public static Exp parseSimple(Token t) throws SyntaxError, IOException {

        if (t instanceof INTEGER) {
            IntLit intL = new IntLit(((INTEGER) t).getDigit());
            return intL;
        }
        else if(t instanceof IDENTIFIER){
            return new Var(((IDENTIFIER) t).getV());
        }
        else {

            return parseCompoundTail(SLexer.getToken());
        }
    }

    public static OP parseOP(Token t) {
        switch (t.toString()) {
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
            if (!(op instanceof MINUS)) {
                if (op instanceof EQUAL) {
                    token = SLexer.getToken();
                }

                token = SLexer.getToken();
                Exp leftArg;
                leftArg = (Exp) parseSimple(token);
                token = SLexer.getToken();

                if (token instanceof RPAR) {

                    int neg = (leftArg).eval() * -1;

                    IntLit intL = new IntLit(neg);
                    token = SLexer.getToken();

                    if (token instanceof EOF) {
                        return intL;
                    } else {
                        // GESTION VARIABLE ICI et MULTIPLE DEF
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
            } else {

                token = SLexer.getToken();
                if (!(token instanceof LPAR)) {


                    Exp leftArg = (Exp) parseSimple(token);
                    token = SLexer.getToken();

                    if (token instanceof RPAR) {

                        int neg = (leftArg).eval(i) * -1;
                        IntLit intL = new IntLit(neg);

                        return intL;

                    } else {
                        Exp rightArg = (Exp) parseSimple(token);

                        token = SLexer.getToken();

                        if (token instanceof RPAR) {


                            return new BinExp(op, leftArg, rightArg);
                        } else {
                            throw new SyntaxError(") missing");
                        }

                    }
                } else if (token instanceof LPAR) {

                    token = SLexer.getToken();

                    Exp e = parseCompoundTail(token);


                    UnExp unEx = new UnExp(e);
                    unEx.setOp(op);

                    return unEx;

                } else {
                    throw new SyntaxError(") missing");
                }
            }
        } else if (token instanceof IF) {

            token = SLexer.getToken();
            Exp leftArg;
            if (token instanceof LPAR) {
                token = SLexer.getToken();
                leftArg = (Exp) parseCompoundTail(token);

            } else {
                leftArg = (Exp) parse(token);
            }

            token = SLexer.getToken();
            Exp centerArg = (Exp) parse(token);


            token = SLexer.getToken();
            Exp rightArg = (Exp) parse(token);


            token = SLexer.getToken();
            if (token instanceof RPAR) {

                return new CondExp(leftArg, centerArg, rightArg);
            } else {
                throw new SyntaxError(") missing");
            }
        }
        else
        {
            System.out.println("b" + token);
            throw new SyntaxError(") missing");
        }
    }

    public abstract int eval(State<Integer> i);
}
