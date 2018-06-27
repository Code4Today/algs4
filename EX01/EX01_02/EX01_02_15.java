import edu.princeton.cs.algs4.*;

public class EX01_02_15 {
    
    public static int[] readInts(String num_str) {
        String[] numbers_str = num_str.split("\\s+");
        int[] numbers = new int[numbers_str.length];
        for (int i = 0; i < numbers_str.length; i++) {
            numbers[i] = Integer.parseInt(numbers_str[i]);
        }
        return numbers;
    }
    
    public static void main(String[] args) {
        int[] a = readInts("65 35 25  48 78\t 68 23\n 98");
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
