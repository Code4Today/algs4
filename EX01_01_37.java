public class EX_01_01_37 {
    public static double[] shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = 0 + StdRandom.uniform(N-i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }
  
    public static void shuffleTest(int M, long N) {
        double[] array = new double[M];
        double[] proba = new double[M];
        for (long i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[j] = j;
            }
            array = shuffle(array);
            for (int j = 0; j < M; j++) {
                if (j == array[j]) {
                    proba[j] += 1.0;
                }
            }
        }
        for (int j = 0; j < M; j++) {
                proba[j] /= N;
        }
        StdOut.println("Probability distribution:");
        printArray(proba);
    }
    
    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%2.3f ", array[i]);
        }
        StdOut.println();
    }
    
    public static void main(String[] args) {
        shuffleTest(10, 100000);
    }
}
