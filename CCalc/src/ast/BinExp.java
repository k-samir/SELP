package ast;

import eval.State;
import typer.Atom;
import typer.SemanticError;
import typer.Sig;
import typer.Type;
import static typer.Atom.*;

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

    public void setLeftP(Exp leftP) {
        this.leftP = leftP;
    }

    public void setRightP(Exp rightP) {
        this.rightP = rightP;
    }

    public Exp getLeftP() {
        return leftP;
    }

    public Exp getRightP() {
        return rightP;
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
    public Atom type() {
        if (leftP.type().unify(BOOL) && rightP.type().unify(BOOL)){
            if ((op.toString().equals("&&") || op.toString().equals("||") || op.toString().equals("==") || op.toString().equals("!="))){
                return Atom.BOOL;
            }
            throw new SemanticError("Error type");
        }
        else if (leftP.type().unify(INT) && rightP.type().unify(INT)){
            if (op.toString().equals("<=") || op.toString().equals("<")
                    || op.toString().equals(">") || op.toString().equals(">=")
                    || op.toString().equals("==") ||op.toString().equals("!=")){
                return BOOL;
            }
            if (!(op.toString().equals("&&") || op.toString().equals("||"))){
                return INT;
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