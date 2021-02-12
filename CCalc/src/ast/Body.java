package ast;

import eval.State;

import java.util.List;

public class Body extends AST {

        List<VarDef> varDef;
        public Exp exp;

        public void setExp(Exp exp) {
                this.exp = exp;
        }

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

        public int eval(State<Integer> stateInteger, State<FuncDef> stateFunDef) {
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

        public int eval(State<Integer> stateInteger) {
                if(exp != null) {
                        String var = exp.toString();
                        for(int i =0;i<varDef.size();i++){
                                if(varDef.get(i).getNom().equals(exp.gen().toString())){
                                        return Integer.parseInt(varDef.get(i).gen());
                                }
                        }
                }
                return this.exp.eval(stateInteger);
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
