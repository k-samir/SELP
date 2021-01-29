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
        return "#include <stdio.h> \nint main() {\n" +
                "  return printf(\"%i\\n\", /*"+ gen.toString()+"*/);\n" +
                "}";
    }

    @Override
    public String gen() {
        System.out.println("ok " + this.toString());
        return this.toString();
    }
}
