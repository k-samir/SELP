package typer;

import java.util.LinkedList;
import java.util.List;

public class Sig {
    public List<Type> args;
    public Type ret;
    public Sig(int arity){
        // initialize argument and return types to variables (ie unknown)
        this.args = new LinkedList<>();
        for (int i = 0; i < arity; i++) {
            this.args.add(new Var());
        }
        this.ret = new Var();
    }
}
