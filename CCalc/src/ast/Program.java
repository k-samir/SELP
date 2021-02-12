package ast;

import eval.State;

import java.util.List;

public class Program extends AST {

    List<FuncDef> funDefs;
    Body body;
    public Program(List<FuncDef> funDefs, Body body){
        this.body = body;
        this.funDefs = funDefs;
    }

    public int eval(State<FuncDef> stateFunDef, State<Integer> stateInteger){
        return this.body.eval(stateInteger,stateFunDef);
    }


    public String genMain(Object gen) {

        String res =  "#include <stdio.h> \n\n" ;

        for(int i = 0;i<funDefs.size();i++){
            res = res + "int " + funDefs.get(i).gen();
        }
        res = res +   "\nint main() {\n" + gen.toString() + "}";

        return res;
    }

    @Override
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
        String res = "";
        // not green
        if(i != 0) {
            for(int j = 0;j<this.body.numberExp();j++){
                res = res  + "    int " + this.body.getVarDef().get(j).getNom() + " = " + this.body.gen(j) + ";\n";
            }
            if(this.body.getExp() != null) {
                    res = res + "    return printf(\"%i\\n\"," + this.body.gen() + ");\n";
            }
        }
        // green test
        else{
            res =  "    return printf(\"%i\\n\", " + this.body.gen() + ");\n";
        }
        return res;
    }

}
