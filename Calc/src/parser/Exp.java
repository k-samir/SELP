package parser;

import eval.State;
import lexer.*;

import java.io.IOException;

public abstract class Exp extends AST {

    public static Exp parse(Token t) throws IOException {
        if (!(t instanceof LPAR) && !(t instanceof MINUS)) {
            return  parseSimple(t);
        } else {
            return parseCompoundTail(SLexer.getToken());
        }
    }

    public static Exp parseSimple(Token t) throws SyntaxError, IOException {
        if (t instanceof INTEGER) {
            return new IntLit(((INTEGER) t).getDigit());
        }
        else if(t instanceof IDENTIFIER){
            return new Var(((IDENTIFIER) t));
        }
        else if (t instanceof LPAR){
            return parseCompoundTail(SLexer.getToken());
        }
        throw new SyntaxError(t.toString());
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

            OP op = parseOP(token);
            if(op.getOp().equals("==")){
                SLexer.getToken();
            }

            Exp exp = parseSimple(SLexer.getToken());
            Token token1 = SLexer.getToken();
            if (op instanceof MINUS && token1 instanceof RPAR) {
                return new UnExp(exp, op);
            }
            else {

                Exp exp2 = parseSimple(token1);
                Token token2 = SLexer.getToken();
                if (token2 instanceof RPAR) {
                    return new BinExp(op, exp, exp2);
                }
                throw new SyntaxError(exp2.toString());
            }
        }
        else if (token instanceof IF) {
            Exp exp1 = parseSimple(SLexer.getToken());
            Exp exp2 = parseSimple(SLexer.getToken());
            Exp exp3 = parseSimple(SLexer.getToken());
            Token token3 = SLexer.getToken();

            if (token3 instanceof RPAR){
                return new CondExp(exp1,exp2,exp3);
            }
            throw new SyntaxError(token3.toString());
        }

        throw new SyntaxError(token.toString());
    }

    public abstract int eval(State<java.lang.Integer> state/*, State<java.lang.Integer> state*/) throws IOException;
}
