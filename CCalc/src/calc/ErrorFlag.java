package calc;

public class ErrorFlag {
    private static boolean error;
    public static void setFlag(){
        error = true;
    }
    public static void reset(){
        error = false;
    }

    public static String getMsg() {
        return "";
    }

    public static boolean getFlag() {
        return false;
    }
}
