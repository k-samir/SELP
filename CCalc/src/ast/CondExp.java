package ast;


import eval.State;
import typer.Atom;
import typer.SemanticError;

public class CondExp extends Exp {
    private final Exp leftP;
    private final Exp centerP;
    private final Exp rightP;

    public CondExp(Exp leftP,Exp centerP, Exp rightP){
        this.leftP = leftP;
        this.centerP = centerP;
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.toString() + " " + this.centerP.toString() + " " + this.rightP.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {

        int val1 = leftP.eval(integerState, funDefState);
        int val2 = centerP.eval(integerState, funDefState);
        int val3 = rightP.eval(integerState, funDefState);

        if(val1 != 0){
            return val2;
        }
        else{
            return val3;
        }

    }

    @Override
    public int eval(State<Integer> integerState) {
        int val1 = leftP.eval(integerState);
        int val2 = centerP.eval(integerState);
        int val3 = rightP.eval(integerState);

        if(val1 != 0){
            return val2;
        }
        else{
            return val3;
        }
    }

    @Override
    public Atom type() {
        if(leftP.type().equals(Atom.BOOL)) {
            if (centerP.type().unify(Atom.INT) && rightP.type().unify(Atom.INT)) {
                return Atom.INT;
            } else if ((centerP.type().unify(Atom.BOOL) && rightP.type().unify(Atom.BOOL))) {
                return Atom.BOOL;
            } else {
                throw new SemanticError("error semantic");
            }
        }
        else{

            throw new SemanticError("error semantic");
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
