package ast;

import eval.State;
import typer.Atom;

import java.util.ArrayList;
import java.util.List;

public class FunCall extends Exp {


    private final FunctionId id;
    private final List<Var> args = new ArrayList<>();
    private Integer res = -1;




    public FunCall(FunctionId nom){
        this.id = nom;


    }


    public void setRes(int res) {
        this.res = res;
    }

    public List<Var> getArgs() {
        return args;
    }


    @Override
    public String gen() {
        return null;
    }

    @Override
    public String gen(int i) {
        return null;
    }

    @Override
    public int eval(State<Integer> integerState, State<FuncDef> funDefState) {
        return res;
    }

    @Override
    public int eval(State<Integer> integerState) {
        return res;
    }

    @Override
    public Atom type() {
        return Atom.FCALL;
    }

    @Override
    public String toString() {
        return id.toString();
    }


}
