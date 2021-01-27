package ast;

import ast.AST;
import ast.Exp;
import ast.FunDef;
import eval.State;


import eval.State;

public abstract class VarDef extends AST {
    private String nom;
    private Exp integer;

    public VarDef(String nom, Exp value){
        super();
        this.nom = nom;
        this.integer = value;
    }

    public String getNom() { return this.nom;}

    public Exp getExp(){ return this.integer;}

    public int eval(State<Integer> integerState, State<FunDef> funDefState) {
        integerState.bind(nom,integer.eval(integerState,funDefState));
        return integer.eval(integerState, funDefState);
    }

}
