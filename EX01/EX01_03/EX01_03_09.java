import edu.princeton.cs.algs4.*;

public class EX01_03_09 {
    
    public static String fixBracket(String s) { 
        Stack<String> s_raw  = new Stack<String>();
        Stack<String> s_re = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals(")")) {
                // find the place to insert a opening bracket
                int operator_count = 2;
                int brackets = 0; // count for bracket block
                while (0 != operator_count && !s_raw.isEmpty()){
                    String ch = s_raw.pop();
                    if (ch.equals("(")) {
                            brackets -= 1;  // finish a bracket
                    }else if (ch.equals(")")) {
                            brackets =+ 1;
                   } else if (isOperator(ch) && (0 == brackets)) {
                            operator_count -= 1;
                        }
                    s_re.push(ch);
                }
                
                // insert the opening bracket
                if (!s_raw.isEmpty()) {
                    s_raw.push(s_re.pop());  // push back the operator if there is one
                }
                s_raw.push("(");  // insert a opening bracket
                
                // push back temp stacks
                while (!s_re.isEmpty()) {
                    s_raw.push(s_re.pop());
                }
                s_raw.push(")");
                
            } else {
                s_raw.push(s.substring(i, i+1));
            }
        }
        String s_fixed = "";
        while (!s_raw.isEmpty()){
            s_fixed = s_raw.pop() + s_fixed;
        }
        return s_fixed;
    }
    
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    
    
    public static void main(String[] args) {
        String s = "1+2)*3-4)*5-6)))";
        StdOut.println(s + " is fixed as " + fixBracket(s));
    }
}

