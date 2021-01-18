package ast;

import calc.State;

public class OP extends AST {
    private String d;

    public OP(String d){
        this.d = d;
    }

    public String toString() {
        return d;
    }




}
