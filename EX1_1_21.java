public class EX1_1_21 {
    public static void main(String[] args) { 
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            if (s.split("\t").length == 3) {
                double div = Double.parseDouble(s.split("\t")[1]) / Integer.parseInt(s.split("\t")[2]);
                StdOut.printf(s+"\t%.3f\n", div);
            }
        }
    }
}