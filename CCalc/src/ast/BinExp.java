package ast;

import eval.State;

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


}

