import java.util.Arrays;

public class EX1_1_28 {

    public static int indexOf(int[] a, int key) {
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
    public static void unrepeat(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (indexOf(a, a[i]) == i){
                StdOut.printf("%d ", a[i]);
            }
        }
    }
    
    
    public static void main(String[] args) {

//        // read the integers from a file
//        In in = new In(args[0]);
//        int[] whitelist = in.readAllInts();

        int[] whitelist = {4, 2, 7, 6, 6, 3, 1, 9, 3, 8, 4};
        // sort the array
        Arrays.sort(whitelist);
        unrepeat(whitelist);
        

//        // read integer key from standard input; print if not in whitelist
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
//            if (BinarySearch.indexOf(whitelist, key) == -1)
//                StdOut.println(key);
//        }
    }
}
