public class EX01_01_27 {
    public static double binomial(int N, int k, double p) {
        double[][] bi_array = new double[N+1][k+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                bi_array[i][j] = -1.0;
            }
        }
        return binomial(N, k, p, bi_array);
    }
    public static double binomial(int N, int k, double p, double[][] bi_array) {
        if (N < 0 || k < 0) 
            return 0.0;
        else if (bi_array[N][k] == -1.0) {
            if (N == 0 && k == 0) 
                bi_array[N][k] = 1.0;
            else{
                bi_array[N][k] = (1.0 - p) * binomial(N-1, k, p, bi_array) + p * binomial(N-1, k-1, p, bi_array);
            }
        }
        return bi_array[N][k];
    }
    public static void main(String[] args) {
        StdOut.println("" + binomial(100, 50, 0.25));
    }
}