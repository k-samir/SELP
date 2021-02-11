package ast;

import ast.AST;
import ast.Exp;
import ast.FunDef;
import ast.VarDef;
import eval.State;
import typer.Type;

import java.util.List;

public class Body extends AST {

        List<VarDef> varDef;
        Exp exp;


        public int numberExp(){
                return varDef.size();
        }
        public Exp getExp() {
                return exp;
        }

        public Body(List<VarDef> varDef, Exp exp) {
                this.varDef = varDef;
                this.exp = exp;

        }

        public List<VarDef> getVarDef() {
                return varDef;
        }

        public int eval(State<Integer> stateInteger, State<FunDef> stateFunDef) {
                if(exp != null) {
                        String var = exp.toString();
                        for(int i =0;i<varDef.size();i++){
                                if(varDef.get(i).getNom().equals(exp.gen().toString())){
                                        return Integer.parseInt(varDef.get(i).gen());
                                }
                        }
                }
                return this.exp.eval(stateInteger,stateFunDef);
               // return this.exp.eval(stateInteger, stateFunDef);
        }


        @Override
        public String gen() {
                return exp.toString();
        }

        @Override
        public String gen(int i) {
                return varDef.get(i).gen();
        }

}
