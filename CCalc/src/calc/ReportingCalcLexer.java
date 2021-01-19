package calc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import parser.CalcLexer;

public class ReportingCalcLexer extends CalcLexer {
    public ReportingCalcLexer(CharStream input) {
        super(input);
    }
    
    public void recover(LexerNoViableAltException e) {
        ErrorFlag.setFlag(); // report error
        super.recover(e);
    }
}