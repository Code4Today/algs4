public class EX1_1_7b {
    public static void main(String[] args) { 
        int sum = 0;
        for (int i = 1; i < 1000; i++)
//            sum = sum + i;
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }
}