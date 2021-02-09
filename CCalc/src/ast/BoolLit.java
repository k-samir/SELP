package ast;

import eval.State;
import typer.Type;

public class BoolLit extends Exp{
    Integer value;

    public BoolLit(String value){
        if(value.equals("true")){
            this.value = 1;
        }
        else{
            this.value = 0;
        }
    }
    @Override
    public String gen() {
        return value.toString();
    }

    @Override
    public String gen(int i) {
        return value.toString();
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return value;
    }

    @Override
    public Type type() {
        return Type.BOOL;
    }
}
