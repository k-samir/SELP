package calc;

import ast.AST;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Calc {
    /**
     * @param args - args[0] is the name of the file to analyze,
     *                otherwise the program is entered at the console.
     */
    public static void main(String[] args) throws IOException {
        InputStream is = switch (args.length) {
            case 0 -> System.in;
            case 1 -> new FileInputStream(args[0]);
            default -> throw new IllegalArgumentException();
        };

        analyze(is);
    }

    public static void analyze(InputStream is) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(is);
        CalcLexer lexer = new ReportingCalcLexer(input);//CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
       // CalcParser parser = new CalcParser(tokens);

        CalcParser parser = new CalcParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());

        ParseTree tree = parser.program();
        System.out.println("ANTLR Syntax tree: " + tree.toStringTree(parser));

        ASTVisitor visitor = new ASTVisitor();
        AST ast = visitor.visit(tree);



    }


}