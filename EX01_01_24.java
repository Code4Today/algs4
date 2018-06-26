public class EX_01_01_24 {
    public static int euclid(int a, int b) {
        // ensure a > b
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
        StdOut.printf("a:%d b:%d\n", a, b);
        if (a % b == 0) 
            return b;
        else
            return euclid(b, a % b);
    }

    
    public static void main(String[] args) {
        int a = 1111111;
        int b = 1234567;
        StdOut.printf("The grestest common factor of %d and %d is %d.\n", a, b, euclid(a, b));
    }
}