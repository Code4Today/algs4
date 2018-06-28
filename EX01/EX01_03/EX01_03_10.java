import edu.princeton.cs.algs4.*;

public class EX01_03_10 {
    
    public static String inFixToPostFix(String s) { 
        Stack<String> stack  = new Stack<String>();
        Stack<String> result  = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
//            StdOut.println("\nStack:"+stack);
            if (s.substring(i, i+1).equals("(")) {
                stack.push("(");
            } else if (s.substring(i, i+1).equals(")")) {
                if (stack.isEmpty()) {
                    throw new UnsupportedOperationException("Wrong expression");
                } else {
                    for (String ch = stack.pop(); !ch.equals("("); ch = stack.pop()) {
//                        StdOut.print(ch + " ");
                        result.push(ch);
                    }
                }
            } else if (isOperator(s.substring(i, i+1))) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && priorOperator(stack.peek(), s.substring(i, i+1))) {
//                    StdOut.print(stack.pop() + " ");
                    result.push(stack.pop());
                }
                stack.push(s.substring(i, i+1));
            } else {
                result.push(s.substring(i, i+1));
//                StdOut.print(s.substring(i, i+1) + " ");
            }
        }
        while (!stack.isEmpty()) {
            result.push(stack.pop());
//            StdOut.print(stack.pop() + " ");
        }
        String s_fixed = "";
        while (!result.isEmpty()){
            s_fixed = result.pop() + s_fixed;
        }
        return s_fixed;
        
    }
    
    public static boolean priorOperator(String s1, String s2) {
        if (isOperator(s1) && isOperator(s2)) {
            if (s1.equals("*") || s1.equals("/")) {
                return true;
            } else if (s2.equals("*") || s2.equals("/")) {
                return false;
            }
            return true;
        } else {
            throw new UnsupportedOperationException("Operator error when comparing prior.");
        }
    } 
    
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    
    
    public static void main(String[] args) {
        String s = "2*3/(2-1)+3*(4-1)";
        StdOut.println(s);
        StdOut.println(inFixToPostFix(s));
    }
}

