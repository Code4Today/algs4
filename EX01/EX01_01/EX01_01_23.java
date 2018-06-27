import java.util.Arrays;
public class EX01_01_23 {
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
        // read the integers from a file
        In in = new In(args[0]);
        String op = args[1];
        
        int[] whitelist = in.readAllInts();
        
        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if ((BinarySearch.indexOf(whitelist, key) == -1) && op.equals("+"))
                StdOut.println(key);
            if ((BinarySearch.indexOf(whitelist, key) != -1) && op.equals("-"))
                StdOut.println(key);
        }
    }
}