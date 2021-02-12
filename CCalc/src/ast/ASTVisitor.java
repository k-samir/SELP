package ast;

import parser.CalcBaseVisitor;
import parser.CalcParser;
import typer.Atom;


import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {

    List<CalcParser.VarDefContext> varDefCtxs;
    List<VarDef> varDefs;


    public AST visitSyntaxError(CalcParser.SyntaxErrorContext ctx) {
        throw new SyntaxError("Error syntax : " + ctx.getText());
    }

    public AST visitProgram(CalcParser.ProgramContext ctx) {

        List<CalcParser.FuncDefContext> funDefCtx = ctx.funcDef();

        List<FuncDef> funDefs = new ArrayList<>();

        for (CalcParser.FuncDefContext funcDefCtx : funDefCtx) {
            FuncDef fd = (FuncDef) visit(funcDefCtx);
            funDefs.add(fd);
        }

        Body body = (Body) visit(ctx.body());
        System.out.println("ok");

        return new Program(funDefs, body);

    }

    public AST visitBody(CalcParser.BodyContext ctx) {
        // retrieve ASTs for definitions
        varDefCtxs = ctx.varDef();
        varDefs = new ArrayList<>();

        for (CalcParser.VarDefContext varDefCtx : varDefCtxs) {
            varDefs.add((VarDef) visit(varDefCtx));
        }
        // retrieve AST for expression
        Exp expr = (Exp) visit(ctx.expression());


        if (expr.getClass().equals(BinExp.class)) {

            // a = ?
            // b = ?
            // a + b

            for (VarDef d : varDefs) {

                if (d.getNom().equals(((BinExp) expr).getLeftP().toString())) {

                    ((BinExp) expr).setLeftP(d.getExp());

                }
                if (d.getNom().equals(((BinExp) expr).getRightP().toString())) {
                    ((BinExp) expr).setRightP(d.getExp());
                }
            }
        }

        // a
        if (expr.type().unify(Atom.VARC)) {
            Boolean checkDef = false;
            for (VarDef d : varDefs) {
                if (d.getNom().equals(expr.toString())) {
                    checkDef = true;
                }
            }
            if (!checkDef) {
                throw new SyntaxError("variable use without a def");
            }

        }

        // return AST for program
        return new Body(varDefs, expr);
    }

    public AST visitVarCall(CalcParser.VarCallContext ctx) {

        return new VarCall(ctx.getText());
    }

    public AST visitVarDef(CalcParser.VarDefContext ctx) {


        Var var1 = (Var) visit(ctx.variableId());

        Exp exp2 = (Exp) visit(ctx.expression());

        for (VarDef d : varDefs) {
            if (d.getNom().equals(var1.s)) {
                throw new SyntaxError("redefinition of a variable");
            }
        }

        return new VarDef(var1, exp2);
    }

    public AST visitVariableId(CalcParser.VariableIdContext ctx) {

        return new Var(ctx.getText());
    }


    public AST visitIntLit(CalcParser.IntLitContext ctx) {

        if (ctx.getText().substring(0, 1).equals("(")) {
            return new IntLit(Integer.parseInt(ctx.getText().substring(1, ctx.getText().length() - 1)));
        } else {
            return new IntLit(Integer.parseInt(ctx.getText()));
        }
    }


    public AST visitUnExp(CalcParser.UnExpContext ctx) {
        String text = ctx.getText();

        if (text.substring(0, 1).equals("!")) {
            String plainText = text.substring(1, text.length());
            if (plainText.equals("true") || plainText.equals("false")) {
                if (plainText.equals("true")) {
                    return new BoolLit("false");
                } else {
                    return new BoolLit("true");
                }
            } else {
                if (Integer.parseInt(plainText) == 0) {
                    text = "1";
                } else {
                    text = "0";
                }
            }

        }
        /*else if((text.substring(0,1).equals("!"))){
            String plainText = text.substring(1,text.length());
            if(plainText.equals("true") || plainText.equals("false")){
                throw new SemanticError("semantic ( -Bool ) ");
            }
        }*/


        int res = 0;
        if (text.substring(0, 1).equals("(")) {
            res = Integer.parseInt(text.substring(1, text.length() - 1));
        } else {


            res = Integer.parseInt(text);
        }
        return new UnExp(res);
    }

    public AST visitFunctionId(CalcParser.FunctionIdContext ctx){
        return new FunctionId(ctx.getText());
    }

    public AST visitFuncDef(CalcParser.FuncDefContext ctx){
        System.out.println("ok");
        FunctionId id = (FunctionId)visit(ctx.head().functionId());
        List<Var> variableIds = new ArrayList<>();

        for(int i = 0;i<ctx.head().variableId().size();i++){

            variableIds.add(new Var(ctx.head().variableId().get(i).getText()));
        }

        Body body = (Body)visit(ctx.body());

        return new FuncDef(id,variableIds,body);

    }


    public AST visitFunCall(CalcParser.FuncDefContext ctx) {

        return new FunCall(ctx.getText());
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

        if (exp1 == null) {
            exp1 = (Exp) visit(ctx.expression(1));
        }
        if (exp2 == null) {
            exp2 = (Exp) visit(ctx.expression(2));
        }

        if (op == null) {

            op = new OP("-");

        }

        BinExp binExp = new BinExp(op, exp1, exp2);
        System.out.println(exp1.toString() + " " + op.toString() + " " + exp2.toString());

        if (!exp1.type().unify(Atom.VARC) && !exp2.type().unify(Atom.VARC)) {
            binExp.type();
        } else {
            //loop in vardef
            if (exp1.type().unify(Atom.VARC)) {

                for (VarDef d : varDefs) {
                    if (d.getNom().equals((exp1.toString()))) {
                        exp1 = d.getExp();

                        System.out.println(exp1);

                    }
                }
            }
            if (exp2.type().unify(Atom.VARC)) {

                for (VarDef d : varDefs) {
                    if (d.getNom().equals((exp2.toString()))) {
                        exp2 = d.getExp();
                    }
                }
            }
            BinExp binExp2 = new BinExp(op, exp1, exp2);
            return binExp2;

        }

        System.out.println("bin final : " + exp1 + " " + op.toString() + " " + exp2);
        return binExp;

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

        CondExp condExp = new CondExp(exp1, exp2, exp3);
        condExp.type();
        return condExp;

    }


    public AST visitBoolean(CalcParser.BooleanContext ctx) {
        return new BoolLit(ctx.getText());
    }


}
