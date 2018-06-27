public class EX01_01_07a {
    public static void main(String[] args) { 
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
             StdOut.printf("%.5f\n", t);
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
    }
}