public class EX1_1_32 {
    public static void drawInputHist(double[] a, int N, double l, double r) {
        double space = (r - l) / N;
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, 100);
        int max_count = 0;
        for (double i = l; i < r; i += space) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if ((a[j] > i) && (a[j] <= (i + space))) {
                    count ++;
                }
            }
            StdDraw.filledRectangle(i, 0, space, count);
            if (count > max_count) {
                max_count = count;
                StdOut.printf("%d\n", max_count);
            }
        }
//         StdDraw.setYscale(0, max_count);
    }
    
    public static void main(String[] args) {
        double[] a = new double[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = StdRandom.random();
        }
        int N = 35;
        double l = 0.0;
        double r = 1.0;
        drawInputHist(a, N, l, r);
    }
}
