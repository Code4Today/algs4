import edu.princeton.cs.algs4.*;

public class EX01_02_06 {
    
    public static Boolean checkCircular(String s1, String s2) {
        if ((s1.length() == s2.length()) && (s1.concat(s1).indexOf(s2) != -1))
            return true;
        else
            return false; 
    }
    
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "o WorldHell";
        String s3 = "o WorldH1ell";   
        StdOut.println(checkCircular(s1, s2));
        StdOut.println(checkCircular(s1, s3));
    }
}
