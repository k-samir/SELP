package ast;

import eval.State;

import java.util.List;

public class FuncDef extends AST {

    private final FunctionId id;
    private final List<Var> variableIds;
    private final Body body;

    public List<Var> getVariableIds() {
        return variableIds;
    }

    public FuncDef(FunctionId id, List<Var> variableIds, Body body){
            this.id = id;
            this.variableIds = variableIds;
            this.body = body;
}

public int nbrArg(){
            return variableIds.size();
    }
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return this.body.eval(integerState,funDefState);
    }
    public int eval(State<Integer> integerState) {
        return this.body.eval(integerState);
    }



    public FunctionId getId() {
        return id;
    }

    @Override
    public String gen() {

        boolean next = false;
         StringBuilder res = new StringBuilder(id + "(");
        for (Var variableId : variableIds) {
            if (next) {
                res.append(",");
            }
            res.append("int ").append(variableId);
            next = true;


        }
        res.append(")");

        if(body.varDef.size() > 0  || body.exp != null){
            res.append("{");
        }

         for(int i = 0 ;i< body.varDef.size();i++){
             res.append(body.gen(i)).append(";");
         }
        if(body.exp != null){
            res.append("\n    return  ").append(body.exp.gen()).append(";");
        }

        if(body.varDef.size() > 0  || body.exp != null){
            res.append("\n}");
        }
        else{
            res.append(";");
        }
         return res.toString();
    }

    @Override
    public String gen(int i) {
        return null;
    }
}
