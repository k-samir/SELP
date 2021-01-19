package parser;

import ast.*;
import calc.Calc;

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

        if(ctx.getText().substring(0,1).equals("(")){
            return new IntLit(Integer.parseInt(ctx.getText().substring(1,ctx.getText().length()-1)));
        }
        else{
            System.out.println(ctx.getText());
            return new IntLit(Integer.parseInt(ctx.getText()));
        }
    }


    public AST visitBinExp(CalcParser.BinExpContext ctx){

        OP op = new OP(ctx.OP().toString());
        Exp exp1 = (Exp)visit(ctx.expression().get(0));
        Exp exp2 = (Exp)visit(ctx.expression().get(1));

        System.out.println(op + " " + exp1 + " " + exp2);

        return new BinExp(op,exp1,exp2);

    }

    public AST visitCondExp(CalcParser.CondExpContext ctx){
        List<CalcParser.ExpressionContext> expressionCtxs = ctx.expression();
        List<Exp> expressions = new ArrayList<>();

        for(CalcParser.ExpressionContext expressionCtx : expressionCtxs){
            expressions.add((Exp)visit(expressionCtx));
        }

        Exp exp1 = expressions.get(0);
        Exp exp2 = expressions.get(1);
        Exp exp3 = expressions.get(2);
        
        return new CondExp(exp1,exp2,exp3);

    }

    public AST visitProgram(CalcParser.ProgramContext ctx){

        List<CalcParser.FuncDefContext> funDefCtx = new ArrayList<>();
        Body body = (Body) visit(ctx.body());
        List<FunDef> funDefs = new ArrayList<>();

        for(CalcParser.FuncDefContext funcDefCtx : funDefCtx){
            funDefs.add((FunDef) visit(funcDefCtx));
        }
        return new Program(funDefs,body);

    }

}
