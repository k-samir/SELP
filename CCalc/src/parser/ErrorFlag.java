package parser;

public class ErrorFlag {
    private static boolean error;
    public static void setFlag(){
        error = true;
    }
    public static void reset(){
        error = false;
    }
}