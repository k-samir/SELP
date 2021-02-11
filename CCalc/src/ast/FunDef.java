package ast;

import eval.State;

import java.util.List;

public class FunDef extends AST {

    private String id;
    private List<Var> variableIds;
    private Body body;


    public FunDef(String id, List<Var> variableIds, Body body){
            this.id = id;
            this.variableIds = variableIds;
            this.body = body;
}

    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return this.body.eval(integerState,funDefState);
    }


    @Override
    public String gen() {
        return null;
    }

    @Override
    public String gen(int i) {
        return null;
    }
}
