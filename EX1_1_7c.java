public class EX1_1_7c {
    public static void main(String[] args) { 
        int sum = 0;
        for (int i = 1; i < 1000; i*=2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }
}