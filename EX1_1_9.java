public class EX1_1_9 {
    public static void main(String[] args) { 
        int x = StdIn.readInt();
        String s = "";
        while (x > 0){
            s = x % 2 + s;
            x = x / 2;
        }
        StdOut.print(s);
    }
}