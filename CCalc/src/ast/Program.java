package ast;

import eval.State;

import java.util.List;

public class Program extends AST {

    List<FunDef> funDefs;
    Body body;
    public Program(List<FunDef> funDefs, Body body){
        this.body = body;
        this.funDefs = funDefs;
    }

    public int eval(State<FunDef> stateFunDef,State<Integer> stateInteger){
        return this.body.eval(stateInteger,stateFunDef);
    }


    public static String genMain(Object gen) {

        return "#include <stdio.h> \n" +
                "" +
                "int main() {\n" +
                 gen.toString() +
                "}";
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
