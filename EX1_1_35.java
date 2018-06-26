public class EX1_1_35 {
    private static int SIDES = 6;
    public static double[] calProbability() {
        double[] dist = new double[2*SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        }
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }
  
    public static double[] rollDice(long N) {
        double[] dice_sum = new double[2*SIDES + 1];
        for (long i = 0; i < N; i++) {
            int dice1 = (int) Math.ceil(StdRandom.random()*6);
            int dice2 = (int) Math.ceil(StdRandom.random()*6);
            dice_sum[dice1+dice2] += 1.0;
        }
        for (int i = 0; i < dice_sum.length; i++) {
            dice_sum[i] /= N;
        }
        return dice_sum;
    }
    
    public static Boolean diffArray(double[] array1, double[] array2) {
        if (array1.length != array2.length) {
            StdOut.println("Dimension of array doesn't match!");
            return false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (Math.abs(array1[i] - array2[i]) > 0.001) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%2.3f ", array[i]);
        }
        StdOut.println();
    }
    
    public static void main(String[] args) {
        double[] dist = calProbability();
        double[] ex = new double[2*SIDES + 1];
        long N = 0;
        while (diffArray(dist, ex)) {
            N++;
            ex = rollDice(N);
            if (0 == N % 1000) {
                 StdOut.printf("Try N=%d...\n", N);
                 StdOut.println("The theoritical probability:");
                 printArray(dist);
                 StdOut.println("The experimental probability:");
                 printArray(ex);
            }
        }
        StdOut.printf("After %d round, the probability of experiment and theory matched.\n", N);
        StdOut.println("The theoritical probability:");
        printArray(dist);
        StdOut.println("The experimental probability:");
        printArray(ex);
    }
}
