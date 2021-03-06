package calc;

import eval.State;
import lexer.Lexer;
import lexer.SLexer;
import parser.Body;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Calc {


    private static SLexer Slexer;

    public static void main(String[] args) throws IOException {
        InputStream is;
        String filename;

        switch (args.length) {
            case 0:
                is = System.in;
                break;
            case 1:
                filename = args[0];
                is = new FileInputStream(filename);
                break;
            default:
                throw new java.lang.IllegalArgumentException();
        }

        System.out.println(interpret(is));
    }

    public static int interpret(InputStream is) throws IOException{
        Slexer.init(is,new Lexer(is));

        ArrayList ar = new ArrayList<>();

        Body b = Body.parse(SLexer.getToken(),ar );
        State stateI = new State<Integer>();
        // AST ast = Exp.parse(SLexer.getToken());
        //System.out.println(ast);

        return b.eval(stateI);
        //return ((Exp)ast).eval();
    }

}


