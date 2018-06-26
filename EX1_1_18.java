public class EX1_1_18 {
    public static int mystery1 (int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery1(a+a, b/2);
        return mystery1(a+a, b/2)+a;
    }
    public static int mystery2 (int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a*a, b/2);
        return mystery2(a*a, b/2)*a;
    }
    public static void main(String[] args) { 
        StdOut.printf("%d\n", mystery1(2, 25));
        StdOut.printf("%d\n", mystery1(3, 11));
        StdOut.printf("%d\n", mystery2(2, 25));
        StdOut.printf("%d\n", mystery2(3, 11));
    }
}
