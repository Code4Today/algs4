public class EX01_01_05 {
    public static void main(String[] args) { 
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        if (x > 0 && x < 1 && y > 0 && y < 1){
            StdOut.println("true");
        } else {
                StdOut.println("false");
        }
    }
}