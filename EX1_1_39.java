import java.util.Arrays;

public class EX1_1_39 {

    public static int BinarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void testBinarySearch(int T) {
        int[] ave_sum = new int[4];
        for (int k = 0; k < T; k++) {
            int N = 100;
            for (int i = 3; i <= 6; i++) {
                N *= 10;
                int[] array1 = new int[N];
                int[] array2 = new int[N];
                for (int j = 0; j < N; j++) {
                    array1[j] = StdRandom.uniform(100000, 1000000);
                    array2[j] = StdRandom.uniform(100000, 1000000);
                }
                Arrays.sort(array2);
                for (int j = 0; j < N; j++) {
                    if ( -1 != BinarySearch(array2, array1[j]))
                        ave_sum[i-3] += 1;
                }
            }
        }
        for (int i = 3; i <= 6; i++) {
            ave_sum[i-3] /= T;
        }
        StdOut.println("Result for N = 10^3, 10^4, 10^5, 10^6:");
        for (int i = 3; i <= 6; i++) {
            StdOut.print(ave_sum[i-3] + " ");
        }
    }
    
    public static void main(String[] args) {
        testBinarySearch(3);
    }
}
