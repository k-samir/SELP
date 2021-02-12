package ast;

import eval.State;

import java.util.List;

public class FuncDef extends AST {

    private FunctionId id;
    private List<Var> variableIds;
    private Body body;

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

public String sign(){
    Boolean next = false;
    String res = id + "(";
    for(int i =0;i<variableIds.size();i++){
        if(next){
            res = res + ",";
        }
        res = res + variableIds.get(i).gen().getClass();
        next = true;


    }
    res = res + ")";


    return res;
}

    public FunctionId getId() {
        return id;
    }

    @Override
    public String gen() {

        Boolean next = false;
         String res = id + "(";
         for(int i =0;i<variableIds.size();i++){
             if(next){
                res = res + ",";
             }
            res = res + "int " + variableIds.get(i);
            next = true;


         }
        res = res + ")";

        if(body.varDef.size() > 0  || body.exp != null){
            res = res + "{";
        }

         for(int i = 0 ;i< body.varDef.size();i++){
             res = res + body.gen(i) + ";";
         }
        if(body.exp != null){
            res = res + "\n    return  " + body.exp.gen()+ ";";
        }

        if(body.varDef.size() > 0  || body.exp != null){
            res = res + "\n}";
        }
        else{
            res = res + ";";
        }
         return res;
    }

    @Override
    public String gen(int i) {
        return null;
    }
}
