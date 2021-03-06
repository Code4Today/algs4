import java.util.Arrays;

public class EX01_01_38 {

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
    
    public static int BruteForceSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (key == a[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        long startTime=System.currentTimeMillis();
        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch(whitelist, key) == -1)
//            if (BruteForceSearch(whitelist, key) == -1)
                StdOut.println(key);
        }
        long endTime=System.currentTimeMillis();
        StdOut.println("The program taks " + (endTime - startTime) + "ms.");
    }
}
