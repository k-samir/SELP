package parser;

import ast.AST;

import java.beans.Expression;
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
        Expression expr = (Expression)visit(ctx.expression());
        // return AST for program
        return new Body(varDefs, expr);
    }

    @Override
    public Object visitExpr(CalcParser.ExprContext ctx) {
        return null;
    }

    public AST visitLit(CalcParser.LitContext ctx) {
        return new Lit(Integer.parseInt(ctx.getText()));
    }

}
