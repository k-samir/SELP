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
        if(ctx.getText().substring(0,1).equals("(")) {
            return new IntLit(Integer.parseInt(ctx.getText().substring(1, ctx.getText().length() - 1)));
        }
        else{

            return new IntLit(Integer.parseInt(ctx.getText()));
        }
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

        System.out.println("tt " + text);
        int res = 0;
        if(text.substring(0,1).equals("(")){
            res = Integer.parseInt(text.substring(1,text.length()-1));
        }
        else{
            res = Integer.parseInt(text);
        }
        return new UnExp(res);
    }




    public AST visitFunCall(CalcParser.IntLitContext ctx) {
        return null;
    }

    public AST visitVarCall(CalcParser.IntLitContext ctx) {
        return null;
    }


    public AST visitBinExp(CalcParser.BinExpContext ctx) {

        Boolean bothBool = false;
        Boolean error = false;

        Exp exp1 = (Exp) visit(ctx.expression().get(0));

        Exp exp2 = (Exp) visit(ctx.expression().get(1));

        try {
            if(exp1.getClass().equals(ast.BoolLit.class) && exp2.getClass().equals(ast.BoolLit.class)){
                bothBool = true;
            }
        }
        catch(Exception e){}



        OP op = null;
        try {
            op = new OP(ctx.OP1().toString());
            if(bothBool){
                error = true;
            }
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP2().toString());
            if(bothBool){
                error = true;
            }
        } catch (Exception e) {

        }
        try {
            op = new OP(ctx.OP3().toString());
            if(bothBool){
                error = true;
            }
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


        if(error){
            throw new SyntaxError("error op Boolean");
        }

        System.out.println("oopopop " + op + " " + exp1 + " " + exp2);

        if (exp1 == null){
            return exp2;
        }
        if (exp2 == null){


            return exp1;
        }

        System.out.println(exp1.getClass());
        System.out.println(exp2.getClass());

        if((exp1.getClass() == ast.BoolLit.class &&  ( exp2.getClass() != ast.BoolLit.class  && exp2.getClass() != ast.BinExp.class ) )
                || ((exp1.getClass() != ast.BoolLit.class && exp1.getClass() != ast.BinExp.class ) && exp2.getClass() == ast.BoolLit.class)){

            throw new SyntaxError("Error Types BinExp");

        }
        if(op == null){
            op = new OP("-");
        }

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
