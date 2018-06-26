public class EX_01_01_30 {
    public static int euclid(int a, int b) {
        // ensure a > b
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
        if (b == 0)
            return 1;
//        StdOut.printf("a:%d b:%d\n", a, b);
        if (a % b == 0) 
            return b;
        else
            return euclid(b, a % b);
    }

    public static Boolean[][] createArray(int N) {
        Boolean[][] a = new Boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((euclid(i, j) == 1) || (euclid(i, j) == 0)) {
                    a[i][j] = true;
                } else {
                    a[i][j] = false;
                }
            }
        }
        return a;
    }
    
    public static void main(String[] args) {

        int N = 7;
        Boolean[][] a = createArray(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j]) {
                    StdOut.print("* ");
                } else {
                    StdOut.print("  ");
                }
            }
            StdOut.println();
        }
    }
}
