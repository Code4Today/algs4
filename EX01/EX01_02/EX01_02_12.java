import edu.princeton.cs.algs4.*;

public class EX01_02_12 {
    
    public static void main(String[] args) {
        SmartDate sd1 = new SmartDate(10, 20, 1901);
        StdOut.println(sd1 + " is " + sd1.dayOfTheWeek());
        SmartDate sd2 = new SmartDate(10, 28, 2038);
        StdOut.println(sd2 + " is " + sd2.dayOfTheWeek());
    }
}
