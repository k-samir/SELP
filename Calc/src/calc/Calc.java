package calc;

import lexer.Lexer;
import lexer.SLexer;
import lexer.Token;
import parser.AST;
import parser.Exp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Calc {


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

        SLexer lexer = new SLexer();
        lexer.init(is,new Lexer(is));

       // reconnaît un programme (qui se limite pour l'instant à une expression)
        // en produisant son arbre de syntaxe abstrait ;
       // et l'affiche.

    // test d'instance

        Exp exp = Exp.parse(lexer.getToken());

        // output result
        System.out.println(exp);

    }

}


