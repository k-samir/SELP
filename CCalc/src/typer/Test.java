package typer;

import static typer.Atom.*;

public class Test {
    public static void main(String[] args) {
        Type t1 = BOOL;
        Type t2 = INT;
        Type t3 = INT;
        System.out.println("t1.unify(t2) false? " + t1.unify(t2)); // t1 = t2
        System.out.println("t2.unify(t1) false? " + t2.unify(t1)); // t2 = t1
        System.out.println("t2.unify(t3) true? " + t2.unify(t3)); // t2 = t3
        System.out.println("t3.unify(t2) true? " + t3.unify(t2)); // t3 = t2
        Type v1 = new Var();
        Type v2 = new Var();
        System.out.println("v1=" + v1.deref());
        System.out.println("v2=" + v2.deref());
        System.out.println("v1.unify(v2) true? " + v1.unify(v2)); // v1 = v2
        System.out.println("v1.unify(t3) true? " + v1.unify(t3)); // v1 = t3
        System.out.println("v2.unify(t2) true? " + v2.unify(t2)); // v2 = t2
        System.out.println("v1=" + v1.deref());
        System.out.println("v2=" + v2.deref());
    }
}
