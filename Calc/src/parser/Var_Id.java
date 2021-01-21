package parser;

public class Var_Id extends Exp{
    String var;

    public Var_Id(String var){
        this.var = var;
    }
    @Override
    public String toString() {
        return var;
    }

    @Override
    public int eval() {
        return 0;
    }
}
