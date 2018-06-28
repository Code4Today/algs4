import edu.princeton.cs.algs4.*;
public class EX01_03_04 {
    public static boolean parentheses(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (0 != stack.size()) {
                String ch_fw = stack.pop();
                String ch_now = s.substring(i, i+1);
                // if not a pair, push the char into stack
                if (!isPair(ch_fw, ch_now)) {
                    stack.push(ch_fw);
                    stack.push(ch_now);
                }
            } else {
                stack.push(s.substring(i, i+1));
            }
        }
        return 0 == stack.size();
    }
    
    public static boolean isPair(String s1, String s2) {
        return ((s1.equals("{") && s2.equals("}")) || (s1.equals("[") && s2.equals("]")) || (s1.equals("(") && s2.equals(")")));
    }
    
    public static void main(String[] args) {
        String s1 = "[()]{}{[()()]()}";
        String s2 = "[(])";
        StdOut.println(s1 + ":" + parentheses(s1));
        StdOut.println(s2 + ":" + parentheses(s2));
    }
}
