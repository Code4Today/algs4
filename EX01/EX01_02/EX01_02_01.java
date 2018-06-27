import edu.princeton.cs.algs4.*;

public class EX01_02_01 {
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2D(Math.random(), Math.random());
            points[i].draw();
        }
        double min_distance = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < min_distance) {
                    min_distance = distance;
                }
            }
        }
        StdOut.println("The min distance is " + min_distance);
    }
}
