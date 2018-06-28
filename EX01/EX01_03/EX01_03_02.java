import edu.princeton.cs.algs4.*;

public class EX01_03_02 {
    
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack;
        stack = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) 
                stack.push(item); 
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
