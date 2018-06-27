import edu.princeton.cs.algs4.*;

public class EX01_02_16 {
    
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 3);
        Rational r2 = new Rational(5, 2);
        Rational r3 = new Rational(1, Integer.MAX_VALUE);
        StdOut.println(r1 + " + " + r2 + " = " + r1.plus(r2) );
        StdOut.println(r1 + " - " + r2 + " = " + r1.minus(r2) );
        StdOut.println(r1 + " * " + r2 + " = " + r1.times(r2) );
        StdOut.println(r1 + " / " + r2 + " = " + r1.divides(r2) );
        StdOut.println(r1 + " / " + r3 + " = " + r1.divides(r3) );
    }
}