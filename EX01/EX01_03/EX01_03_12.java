public class EX01_03_12 {
    
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> new_stack  = new Stack<String>();
        for (String s: stack) {
            new_stack.push(s);
        }
        return new_stack;
    }
    
    
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("543");
        stack.push("345");
        stack.push("45");
        stack.push("983");
        stack.pop();
        StdOut.println(stack.peek());
        StdOut.println(stack.pop());
        Stack<String> stack2 = copy(stack);
        stack2.push("761");
        StdOut.println("Stack 1: " + stack);
        StdOut.println("Stack 2: " + stack2);
    }
}

