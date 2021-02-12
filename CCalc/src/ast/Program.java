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

        StringBuilder res = new StringBuilder("#include <stdio.h> \n\n");

        for (FuncDef funDef : funDefs) {
            res.append("\nint ").append(funDef.gen());
        }
        res.append("\n\nint main() {\n").append(gen.toString()).append("}");

        return res.toString();
    }

    @Override
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
        StringBuilder res = new StringBuilder();
        // not green
        if(i != 0) {
            for(int j = 0;j<this.body.numberExp();j++){
                res.append("    int ").append(this.body.getVarDef().get(j).getNom()).append(" = ").append(this.body.gen(j)).append(";\n");
            }
            if(this.body.getExp() != null) {
                    res.append("    return printf(\"%i\\n\",").append(this.body.gen());

                try{
                    Integer.parseInt(this.body.gen());
                    res.append(");\n");
                }
                catch(Exception e){
                    res.append("());\n");
                }

                }

            }

        // green test
        else{
            res = new StringBuilder("    return printf(\"%i\\n\", " + this.body.gen() + ");\n");
        }
        return res.toString();
    }

}
