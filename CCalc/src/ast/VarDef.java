package ast;

import ast.AST;
import ast.Exp;
import ast.FunDef;
import eval.State;


import eval.State;

public class VarDef extends AST {
    private Var nom;
    private Exp integer;

    public VarDef(Var nom, Exp value){
        super();
        this.nom = nom;
        this.integer = value;
    }

    public String getNom() { return nom.toString();}

    public Exp getExp(){ return this.integer;}

    public int eval(State<Integer> integerState, State<FunDef> funDefState) {

        integerState.bind(nom.toString(),integer.eval(integerState,funDefState));
        return integer.eval(integerState, funDefState);
    }

    @Override
    public String gen() {
        return integer.toString();
    }

    @Override
    public String gen(int i) {
        return integer.toString();
    }
}
