public class EX01_01_22 {
    public static int rank(int[] a, int key) {
        return rank(a, key, 0, a.length - 1);
    }
    public static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        StdOut.printf("lo:%d a[lo]:%d hi:%d a[hi]:%d\n", lo,a[lo], hi, a[hi]);
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(a, key, lo, mid - 1);
        else if (key > a[mid]) return rank(a, key, mid + 1, hi);
        else return mid;
    }
    
    public static void main(String[] args) {
        int[] a = {-3344, -567, -56, -3, 2, 6, 36, 84, 87, 104, 341};
        int key = 341;
        StdOut.printf("Number %d is the %d element of array.", key, rank(a, key));
    }
}