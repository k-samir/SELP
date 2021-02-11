package ast;

import eval.State;
import typer.Atom;
import typer.Type;

public class VarCall extends Exp{

    private String nom;

    public VarCall(String nom){
        super();
        this.nom = nom;

    }

    public String getNom() { return nom;}

    @Override
    public String toString(){
        return nom;
    }
    @Override
    public String gen(int i) {
        return nom;
    }

    @Override
    public String gen() {
        return nom;
    }

    @Override
    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        return 0;
    }

    @Override
    public Atom type() {
        return Atom.VARC;
    }
}