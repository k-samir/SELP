package ast;

import eval.State;
import typer.SemanticError;
import typer.Sig;
import typer.Type;

import java.util.OptionalInt;

public class BinExp extends Exp {
    private Exp leftP;
    private OP op;
    private Exp rightP;

    public BinExp(OP op, Exp leftP,Exp rightP){
        this.op =  op;
        this.leftP = leftP;
        this.rightP = rightP;




    }


    public String toString() {
        //return this.leftP.toString() + " " + this.op.toString() + " " + this.rightP.toString();

        return String.valueOf(this.eval());
    }

    public int eval() {

            int val1 = Integer.parseInt(leftP.toString());
            int val2 = Integer.parseInt(rightP.toString());


        switch(op.toString()) {
            case "+":
                return val1 + val2;
            case "-":

                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":

                return val1 / val2;
            case "&&":
                if (val1 == 0 || val2 == 0) {
                    return 0;
                } else {
                    return 1;
                }
            case "||":
                if (val1 != 0 && val2 != 0) {
                    return 1;
                }
                 else {

                    return 0;
                }
            case "!=":
                if (val1 != val2) {
                    return 1;
                } else {
                    return 0;
                }
            case "==":
                if (val1 == val2) {
                    return 1;
                } else {
                    return 0;
                }

            case "<":
                if (val1 < val2) {
                    return 1;
                } else {
                    return 0;
                }
            case ">":
                if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            case "<=":
                if (val1 <= val2) {
                    return 1;
                } else {
                    return 0;
                }
            case ">=":
                if (val1 >= val2) {
                    return 1;
                } else {
                    return 0;
                }
            default:
                return 0;
        }

    }
    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

        int val1 = Integer.parseInt(leftP.toString());
        int val2 = Integer.parseInt(rightP.toString());


        switch(op.toString()) {
            case "+":
                return val1 + val2;
            case "-":

                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":

                return val1 / val2;
            case "&&":
                if (val1 == 0 || val2 == 0) {
                    return 0;
                } else {
                    return 1;
                }
            case "||":
                if (val1 != 0 && val2 != 0) {
                    return 1;
                }
                else {

                    return 0;
                }
            case "!=":
                if (val1 != val2) {
                    return 1;
                } else {
                    return 0;
                }
            case "==":
                if (val1 == val2) {
                    return 1;
                } else {
                    return 0;
                }

            case "<":
                if (val1 < val2) {
                    return 1;
                } else {
                    return 0;
                }
            case ">":
                if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            case "<=":
                if (val1 <= val2) {
                    return 1;
                } else {
                    return 0;
                }
            case ">=":
                if (val1 >= val2) {
                    return 1;
                } else {
                    return 0;
                }
            default:
                return 0;
        }

    }

    @Override
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
            
        return this.toString();
    }

    @Override
    //public Type type(State<Type> stVar, State<Sig> stFun) {
    public Type type() {

        if(leftP.type().equals(Type.INT) && rightP.type().equals(Type.INT) ){
            switch(op.toString()) {
                case "+":
                    return Type.INT;
                case "-":
                     return Type.INT;
                case "*":
                     return Type.INT;
                case "/":
                    return Type.INT;
                case "!=":
                    return Type.INT;
                case "==":
                    return Type.INT;
                case "<":
                    return Type.INT;
                case ">":
                    return Type.INT;
                case "<=":
                    return Type.INT;
                case ">=":
                    return Type.INT;

                case "&&":
                    throw new SemanticError("error semantic");
                case "||":
                    throw new SemanticError("error semantic");

                default:
                    throw new SemanticError("error semantic");
            }
        }
        else if(leftP.type().equals(Type.BOOL) && rightP.type().equals(Type.BOOL) ) {
            switch(op.toString()) {
                case "+":
                    throw new SemanticError("error semantic");
                case "-":
                    throw new SemanticError("error semantic");
                case "*":
                    throw new SemanticError("error semantic");
                case "/":
                    throw new SemanticError("error semantic");
                case "!=":
                    throw new SemanticError("error semantic");

                case "<":
                    throw new SemanticError("error semantic");
                case ">":
                    throw new SemanticError("error semantic");
                case "<=":
                    throw new SemanticError("error semantic");
                case ">=":
                    throw new SemanticError("error semantic");

                case "&&":
                    return Type.BOOL;
                case "||":
                    return Type.BOOL;
                case "==":
                    return Type.BOOL;
                default:
                    throw new SemanticError("error semantic");
            }

        }
        else{
            throw new SemanticError("error semantic");
        }
    }


}

