package ast;

import parser.CalcBaseVisitor;
import parser.CalcParser;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {

    public AST visitBody(CalcParser.BodyContext ctx) {
        // retrieve ASTs for definitions
        List<CalcParser.VarDefContext> varDefCtxs = ctx.varDef();
        List<VarDef> varDefs = new ArrayList<>();
        for (CalcParser.VarDefContext varDefCtx : varDefCtxs)
            varDefs.add((VarDef) visit(varDefCtx));
        // retrieve AST for expression
        Exp expr = (Exp) visit(ctx.expression());
        // return AST for program
        return new Body(varDefs, expr);
    }

    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        return new IntLit(Integer.parseInt(ctx.getText()));
    }

    public AST visitUnExp(CalcParser.UnExpContext ctx) {
        String text = ctx.getText();

        if(text.substring(0,1).equals("!")){
            String plainText = text.substring(1,text.length());
            if(plainText.equals("true") || plainText.equals("false")){
                if (plainText.equals("true")) {
                    return new BoolLit("false");
                } else {
                    return new BoolLit("true");
                }
            }
            else {
                if (Integer.parseInt(plainText) == 0) {
                    text = "1";
                } else {
                    text = "0";
                }
            }

        }
        return new UnExp(Integer.parseInt(text));
    }




    public AST visitFunCall(CalcParser.IntLitContext ctx) {
        return null;
    }

    public AST visitVarCall(CalcParser.IntLitContext ctx) {
        return null;
    }


    public AST visitBinExp(CalcParser.BinExpContext ctx) {

        OP op = null;
        try {
            op = new OP(ctx.OP1().toString());
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP2().toString());
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP3().toString());
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP4().toString());
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP5().toString());
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP6().toString());
        } catch (Exception e) {

        }


        Exp exp1 = (Exp) visit(ctx.expression().get(0));

        Exp exp2 = (Exp) visit(ctx.expression().get(1));



        //System.out.println("oopopop " + op + " " + exp1 + " " + exp2);

        return new BinExp(op, exp1, exp2);

    }


    public AST visitCondExp(CalcParser.CondExpContext ctx) {
        List<CalcParser.ExpressionContext> expressionCtxs = ctx.expression();
        List<Exp> expressions = new ArrayList<>();

        for (CalcParser.ExpressionContext expressionCtx : expressionCtxs) {
            expressions.add((Exp) visit(expressionCtx));
        }

        Exp exp1 = expressions.get(0);
        Exp exp2 = expressions.get(1);
        Exp exp3 = expressions.get(2);

        return new CondExp(exp1, exp2, exp3);

    }

    public AST visitProgram(CalcParser.ProgramContext ctx) {

        List<CalcParser.FuncDefContext> funDefCtx = new ArrayList<>();
        Body body = (Body) visit(ctx.body());
        List<FunDef> funDefs = new ArrayList<>();

        for (CalcParser.FuncDefContext funcDefCtx : funDefCtx) {
            funDefs.add((FunDef) visit(funcDefCtx));
        }
        return new Program(funDefs, body);

    }

    public AST visitBoolean(CalcParser.BooleanContext ctx) {
        return new BoolLit(ctx.getText());
    }


}
