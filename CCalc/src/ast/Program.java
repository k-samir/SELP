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

    public int eval(){
        State<FunDef> stateFunDef = new State<>();
        State<List<String>> stateVariable = new State<>();
        State<Integer> stateInteger = new State<>();

        for(FunDef funDef : funDefs){
            funDef.eval(stateInteger, stateFunDef);
        }
        return this.body.eval(stateInteger,stateFunDef);


    }
    public static String genMain(Object gen) {
        return "";
    }
}
