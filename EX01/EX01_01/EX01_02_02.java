import edu.princeton.cs.algs4.*;

public class EX01_02_02 {
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            String line = StdIn.readLine();
            String[] string_num = line.split(" ");
            intervals[i] = new Interval1D(Double.parseDouble(string_num[0]), Double.parseDouble(string_num[1]));
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " " + intervals[j]);
                }
            }
        }
    }
}
