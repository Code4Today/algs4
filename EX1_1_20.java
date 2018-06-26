public class EX1_1_20 {
    public static double lnFactorial (int n) {
        if (n <= 1) return 0;
        return Math.log(n) + lnFactorial(n-1);
    }
    public static void main(String[] args) { 
        StdOut.printf("%f", lnFactorial(6));
    }
}