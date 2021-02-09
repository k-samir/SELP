package ast;


import eval.State;
import typer.SemanticError;
import typer.Type;

public class CondExp extends Exp {
    private Exp leftP;
    private Exp centerP;
    private Exp rightP;

    public CondExp(Exp leftP,Exp centerP, Exp rightP){
        this.leftP = leftP;
        this.centerP = centerP;
        this.rightP = rightP;
    }

    public String toString() {
        return this.leftP.toString() + " " + this.centerP.toString() + " " + this.rightP.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

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
    public Type type() {
        if(leftP.type().equals(Type.BOOL)) {
            if (centerP.type().equals(Type.INT) && rightP.type().equals(Type.INT)) {
                return Type.INT;
            } else if ((centerP.type().equals(Type.BOOL) && rightP.type().equals(Type.BOOL))) {
                return Type.BOOL;
            } else {
                throw new SemanticError("error semantic");
            }
        }
        else{
            System.out.println(leftP.toString());
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
