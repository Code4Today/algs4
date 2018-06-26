public class EX_01_01_31 {
    public static void randomConnect(int N, double p) {
        StdDraw.circle(0.5, 0.5, 0.5);
        if (N <= 0) {
            return;
        }
        double[][] point_pos = new double[N][2];
        for (int i = 0; i < N; i++) {
            point_pos[i][0] = 0.5 + 0.5 * Math.cos(Math.PI*2.0*i/N);
            point_pos[i][1] = 0.5 + 0.5 * Math.sin(Math.PI*2.0*i/N);
            StdDraw.filledCircle(point_pos[i][0], point_pos[i][1], 0.05);
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++){
                if (StdRandom.random() > p) {
                    StdDraw.line(point_pos[i][0], point_pos[i][1], point_pos[j][0], point_pos[j][1]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        randomConnect(12, 0.5);
        
    }
}
