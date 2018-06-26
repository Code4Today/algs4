public class EX_01_01_14 {
    public static int floorIntLog2(int N) {
        if (N < 1) {
            StdOut.println("Input should be larger than 0.");
            return 0;
        } else {
            int exp_num = 1;
            int i;
            for (i = 0; exp_num < N; i++) {
                exp_num = exp_num * 2;
            }
            return i-1;
        }
    }
    public static void main(String[] args) { 
        int N = 32;
        StdOut.printf("%d", floorIntLog2(N));
    }
}