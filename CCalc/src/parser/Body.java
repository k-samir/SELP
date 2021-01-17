package parser;

import ast.AST;

import java.util.List;

public class Body extends AST {

        List<VarDef> varDef;
        Exp exp;

        public Body(List<VarDef> varDef, Exp exp) {
                this.varDef = varDef;
                this.exp = exp;
        }
}
