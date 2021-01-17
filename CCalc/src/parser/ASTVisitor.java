package parser;

import ast.AST;
import ast.BinExp;
import ast.IntLit;
import ast.OP;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {

    public AST visitBody(CalcParser.BodyContext ctx) {
        // retrieve ASTs for definitions
        List<CalcParser.VarDefContext> varDefCtxs = ctx.varDef();
        List<VarDef> varDefs = new ArrayList<>();
        for (CalcParser.VarDefContext varDefCtx : varDefCtxs)
            varDefs.add((VarDef)visit(varDefCtx));
        // retrieve AST for expression
        Exp expr = (Exp)visit(ctx.expression());
        // return AST for program
        return new Body(varDefs, expr);
    }

    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        return new IntLit(Integer.parseInt(ctx.getText()));
    }

    public AST visitBinExp(CalcParser.BinExpContext ctx){
        System.out.println(ctx.OP());
        OP op = new OP(ctx.OP().toString());
        Exp exp1 = (Exp)visit(ctx.expression().get(0));
        Exp exp2 = (Exp)visit(ctx.expression().get(1));
        return new BinExp(op,exp1,exp2);

    }

}
