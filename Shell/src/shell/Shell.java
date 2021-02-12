package shell;

import java.io.IOException;

public class Shell {
  static final String SHELL = "cmd";
  //static final String SHELL = "bash";
	
  public static void main(String[] args) throws IOException, InterruptedException {
    test("pwd > ../../test/test.txt");
    test("gcc ../../test/test.c");
   }
	
  static void test(String shellCmd) throws IOException, InterruptedException {
    String[] cmd = {SHELL, "-c", shellCmd};
    Runtime.getRuntime().exec(cmd).waitFor();
  }
}

