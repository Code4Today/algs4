import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class EX01_02_09 {
    
    public static int rank(int[] a, int key, Counter count) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            count.increment();
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public static void main(String[] args) {

        // read the integers from a file
        Counter count = new Counter("Number of searched key");
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(whitelist, key, count) == -1)
                StdOut.println(key);
        }
        StdOut.println("Counter has counted " + count.tally() + " times.");
    }
}
