package ast;

import eval.State;
import typer.Atom;

import java.util.List;

public class FunCall extends Exp {
    String nom;
    List<Integer> args;
    public Integer res = -1;



    public FunCall(String nom){
        this.nom = nom;

    }

    public String getRes() {
        return String.valueOf(res);
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<Integer> getArgs() {
        return args;
    }

    public String sign(){
        Boolean next = false;
        String res = nom + "(";
        for(int i =0;i<args.size();i++){
            System.out.println(args.get(i));
            if(next){
                res = res + ",";
            }
            res = res + args.get(i).getClass();
            next = true;


        }
        res = res + ")";


        return res;
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
        return nom;
    }
}
