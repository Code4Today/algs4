import java.util.Arrays;

public class EX1_1_29 {

    public static int rank(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    
    public static int count(int[] a, int key) {
        int key_count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key){
                key_count++;
            }
        }
        return key_count;
    }
    
    
    public static void main(String[] args) {

//        // read the integers from a file
//        In in = new In(args[0]);
//        int[] whitelist = in.readAllInts();

        int[] whitelist = {4, 2, 7, 6, 6, 3, 1, 9, 3, 8, 4};
        // sort the array
        Arrays.sort(whitelist);
        StdOut.printf("%d number is lower than 5 in list.\n", rank(whitelist, 5));
        StdOut.printf("%d number is lower than 6 in list.\n", rank(whitelist, 6));
        StdOut.printf("%d number is equal to 6 in list.\n", count(whitelist, 6));

//        // read integer key from standard input; print if not in whitelist
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
//            if (BinarySearch.indexOf(whitelist, key) == -1)
//                StdOut.println(key);
//        }
    }
}
