import edu.princeton.cs.algs4.*;

public class EX01_03_11 {
    
    public static double evaluatePostFix(String s) {
        Stack<Double> numbers  = new Stack<Double>();
        String s_post = inFixToPostFix(s);
        for (int i = 0; i < s_post.length(); i++) {
            String ch = s_post.substring(i, i+1);
            if (isOperator(ch)) {
                double n1 = numbers.pop();
                double n2 = numbers.pop();
                double n_r = calculate(n2, n1, ch);
                numbers.push(n_r);
            } else {
                numbers.push(Double.parseDouble(ch));
            }
        }
        return numbers.pop();
    }
    
    public static double calculate(double n1, double n2, String ch) {
        if (ch.equals("+")) {
            return n1 + n2;
        } else if (ch.equals("-")) {
            return n1 - n2;
        } else if (ch.equals("*")) {
            return n1 * n2;
        } else if (ch.equals("/")) {
            return n1 / n2;
        } else {
            throw new UnsupportedOperationException("Wrong expression");
        }
    }
    
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
        StdOut.println("Raw: " + s);
        StdOut.println("Post: " + inFixToPostFix(s));
        StdOut.println("Result: " + evaluatePostFix(s));
    }
}

