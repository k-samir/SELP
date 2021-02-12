package lexer;

public class INTEGER implements Token {
    int digit;
    public INTEGER(String digit){
        this.digit = Integer.parseInt(digit);
    }
    @Override
    public String toString() {
        return "INTEGER:" + this.digit;
    }

    public int getDigit(){
        return digit;
    }
    public void setDigit(int d){ this.digit = d;}
}
