public class EX1_1_15 {
    public static int[] histogram (int[] a, int M) {
        int[] his = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    his[i]++;
                }
            }
        }
        return his;
    }
    public static void main(String[] args) { 
        int[] a = {1, 5, 3, 7, 2, 7, 3, 7, 3};
        int[] result = histogram(a, 10);
        for (int i = 0; i < result.length; i++) {
            StdOut.printf("%3d", result[i]);
        }
    }
}