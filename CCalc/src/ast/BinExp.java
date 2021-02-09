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
        State<Integer> integerState = null;
        State<FunDef> funDefState = null;
        return String.valueOf(this.eval(integerState, funDefState));
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

        int val1 = leftP.eval( integerState,  funDefState);
        int val2 = rightP.eval( integerState,  funDefState);

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
                if(val1 != 0 && val2 != 0){
                    return 1;
                }
                else{
                    return 0;
                }
            case "||":
                if(val1 != 0 || val2 != 0){
                    return 1;
                }
                else{
                    return 0;
                }
            case "==":
                if (val1 == val2){
                    return 1;
                }
                else{
                    return 0;
                }
            case "!=":
                if (val1 != val2){
                    return 1;
                }
                else {
                    return 0;
                }
            case "<=":
                if (val1 <= val2){
                    return 1;
                }
                else {
                    return 0;
                }
            case ">=":
                if (val1 >= val2){
                    return 1;
                }
                else {
                    return 0;
                }
            case "<":
                if (val1 < val2){
                    return 1;
                }
                else {
                    return 0;
                }
            case ">":
                if (val1 > val2){
                    return 1;
                }
                else {
                    return 0;
                }

            default:
                return 0;
        }

    }

    @Override
    public Type type() {
        if (leftP.type().equals(Type.BOOL) && rightP.type().equals(Type.BOOL)){
            if ((op.toString().equals("&&") || op.toString().equals("||") || op.toString().equals("==") || op.toString().equals("!="))){
                return Type.BOOL;
            }
            throw new SemanticError("Error type");
        }
        else if (leftP.type().equals(Type.INT) && rightP.type().equals(Type.INT)){
            if (op.toString().equals("<=") || op.toString().equals("<")
                    || op.toString().equals(">") || op.toString().equals(">=")
                    || op.toString().equals("==") ||op.toString().equals("!=")){
                return Type.BOOL;
            }
            if (!(op.toString().equals("&&") || op.toString().equals("||"))){
                return Type.INT;
            }
            throw new SemanticError("Error type");
        }
        else throw new SemanticError("Error type");
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