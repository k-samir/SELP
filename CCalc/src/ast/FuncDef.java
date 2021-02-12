package ast;

import eval.State;

import java.util.List;

public class FuncDef extends AST {

    private FunctionId id;
    private List<Var> variableIds;
    private Body body;


    public FuncDef(FunctionId id, List<Var> variableIds, Body body){
            this.id = id;
            this.variableIds = variableIds;
            this.body = body;
}

    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return this.body.eval(integerState,funDefState);
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
            res = res + "\n    return printf(\"%i\\n\", " + body.exp.gen()+ ");";
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
