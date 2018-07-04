public class EX01_03_42 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(543);
        stack.push(345);
        stack.push(45);
        stack.push(983);
        Stack<Integer> t = new Stack<Integer>(stack);
        StdOut.println("s: " + stack);
        StdOut.println("t: " + t);
        stack.pop();
        StdOut.println("s: " + stack);
        StdOut.println("t: " + t);
    }
}
