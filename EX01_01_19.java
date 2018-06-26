public class EX_01_01_19 {
    public static long F (int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    public static long F2 (int N) {
        long[] F_array = new long[N+1];
        if (N == 0) return 0;
        if (N == 1) return 1;
        F_array[0] = 0;
        F_array[1] = 1;
        for (int i = 2; i <= N; i++) {
            F_array[i] = F_array[i-1] + F_array[i-2];
        }
        return F_array[N];
    }
    public static void main(String[] args) { 
        for (int N = 0; N < 100; N++) 
            StdOut.println(N + " " + F2(N));
    }
}