package parser;

import ast.AST;
import ast.Exp;
import ast.FunDef;
import ast.VarDef;
import eval.State;

import java.util.List;

public class Body extends AST {

        List<VarDef> varDef;
        Exp exp;

        public Body(List<VarDef> varDef, Exp exp) {
                this.varDef = varDef;
                this.exp = exp;
        }

        public int eval() {
                return 0;
        }

        public int eval(State<Integer> stateInteger, State<FunDef> stateFunDef) {
                return 0;
        }
}
