import edu.princeton.cs.algs4.*;

public class EX01_02_03 {
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = new Interval2D[N];
        double[] boundarys = new double[4];
        Interval1D[][] inv = new Interval1D[N][2];
        Point2D[][] points = new Point2D[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                boundarys[j] = StdRandom.random() * (max - min) + min;
            }
            if (boundarys[0] > boundarys[1]) {
                double temp = boundarys[0];
                boundarys[0] = boundarys[1];
                boundarys[1] = temp;
            } 
            inv[i][0] = new Interval1D(boundarys[0], boundarys[1]);
            if (boundarys[2] > boundarys[3]) {
                double temp = boundarys[2];
                boundarys[2] = boundarys[3];
                boundarys[3] = temp;
            } 
            inv[i][1] = new Interval1D(boundarys[2], boundarys[3]);
            points[i][0] = new Point2D(boundarys[0], boundarys[2]);
            points[i][1] = new Point2D(boundarys[1], boundarys[3]);
            intervals[i] = new Interval2D(inv[i][0], inv[i][1]);
            intervals[i].draw();
        }
        
        int n_contain = 0;
        int n_intersect = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((intervals[i].contains(points[j][0])) && (intervals[i].contains(points[j][1]))) {
                    n_contain++;
                }
                if (intervals[i].intersects(intervals[j])) {
                    n_intersect++;
                }
            }
        }
        StdOut.println("Contains: " + n_contain + "\t Intersects: " + n_intersect);
    }
}
