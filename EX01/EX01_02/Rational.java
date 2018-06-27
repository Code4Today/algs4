import edu.princeton.cs.algs4.*;

public class Rational {
    private int numerator;
    private int denominator;
    
    public Rational(int numerator, int denominator) {
        if (0 == denominator) {
            throw new ArithmeticException("Divide by zero!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        refresh();
    }
    
    public Rational plus(Rational b) {
        long re_denominator = denominator * (long) b.denominator;
        long re_numerator = numerator * (long) b.denominator + denominator * (long) b.numerator;
        if (overflow(re_denominator) || overflow(re_numerator)) {
            throw new ArithmeticException("Overflow!");
        }
        return new Rational((int) re_numerator, (int) re_denominator);
    }
    
    public Rational minus(Rational b) {
        long re_denominator = denominator * (long) b.denominator;
        long re_numerator = numerator * (long) b.denominator - denominator * (long) b.numerator;
        if (overflow(re_denominator) || overflow(re_numerator)) {
            throw new ArithmeticException("Overflow!");
        }
        return new Rational((int) re_numerator, (int) re_denominator);
    }
    
    public Rational times(Rational b) {
        long re_denominator = denominator * (long) b.denominator;
        long re_numerator = numerator * (long) b.numerator;
        if (overflow(re_denominator) || overflow(re_numerator)) {
            throw new ArithmeticException("Overflow!");
        }
        return new Rational((int) re_numerator, (int) re_denominator);
    }
    
    public Rational divides(Rational b) {
        long re_denominator = denominator * (long) b.numerator;
        long re_numerator = numerator * (long) b.denominator;
//        StdOut.println("numerator=" + re_numerator + ", denominator=" + re_denominator + ", int_MAX=" + Integer.MAX_VALUE + ", long_MAX=" + Long.MAX_VALUE);
        if (overflow(re_denominator) || overflow(re_numerator)) {
            throw new ArithmeticException("Overflow!");
        }
        return new Rational((int) re_numerator, (int) re_denominator);
    }
    
    public Boolean overflow(long a) {
        if ((a < Integer.MAX_VALUE) && (a > Integer.MIN_VALUE)) {
            return false;
        } else {
            return true;
        }
    }
    
    public void refresh() {
        int common_factor = euclid(numerator, denominator);
        numerator /= common_factor;
        denominator /= common_factor;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    
    public static int euclid(int a, int b) {
        // ensure a > b
        a = Math.abs(a);
        b = Math.abs(b);
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
//        StdOut.printf("a:%d b:%d\n", a, b);
        if (a % b == 0) 
            return b;
        else
            return euclid(b, a % b);
    }
    
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Rational that = (Rational) x;
        if (this.numerator != that.numerator)            return false;
        if (this.denominator != that.denominator)        return false;
        return true;
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
}
