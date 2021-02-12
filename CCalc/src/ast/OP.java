package ast;

public class OP extends AST {
    private final String d;

    public OP(String d){
        this.d = d;
    }

    public String toString() {
        return d;
    }

    @Override
    public String gen() {
        return this.toString();
    }

    @Override
    public String gen(int i) {
        return this.toString();
    }


}
