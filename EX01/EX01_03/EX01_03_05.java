import edu.princeton.cs.algs4.*;
//import java.util.Iterator;

public class EX01_03_05 {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int N = 1024;
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d: stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }
}
