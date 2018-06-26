public class EX1_1_33 {
    private static double[][] zero = {{0.0}};
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length){
            StdOut.println("Dimension of matrix doesn't match!");
            return 0.0;
        } else {
            double temp = 0.0;
            for (int i = 0; i < x.length; i++) {
                temp += x[i] * y[i];
            }
            return temp;
        }
    }
    
    public static double[][] mult(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            StdOut.println("Dimension of matrix doesn't match!");
            return zero;
        } else {
            double[][] re = new double[a.length][b[0].length];
            double[][] b_t = transpose(b);
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    re[i][j] = dot(a[i], b_t[j]);
                }
            }
            return re;
        }
    }
    
    public static double[] mult(double[][] a, double[] x) {
        double[][] b = new double[1][x.length];
        b[0] = x;
        double[][] re = mult(a, transpose(b));
        return transpose(re)[0];
    }
    
    public static double[] mult(double[] y, double[][] a) {
        double[][] t = new double[1][y.length];
        t[0] = y;
        double[][] re = mult(t, a);
        return re[0];
    }
    
    public static double[][] transpose(double[][] a) {
//        StdOut.println("Before transpose:");
//        printMatrix(a);
        int row = a.length;
        int col = a[0].length;
        double[][] b = new double[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                b[i][j] = a[j][i];
            }
        }
//        StdOut.println("After transpose:");
//        printMatrix(b);
        return b;
    }
    
    public static void printMatrix(double[][] a) {
        for (double[] i:a) {
            printMatrix(i);
        }
    }
    
    public static void printMatrix(double[] a) {
        for (double i:a) {
            StdOut.printf("%4.2f ", i);
        }
        StdOut.println();
    }
    
    public static void main(String[] args) {
        double[][] matrix3_2 = {{3, 6}, {0, 2}, {4, 1}};
        double[][] matrix2_3 = {{5, 1, 4}, {2, 0, 1}};
        double[] vector3a = {2, 4, 1};
        double[] vector3b = {1, 2, 1};
        double[] vector2 = {1, 3};
        StdOut.printf("Dot of vector 3a and 3b:\n%f\n", dot(vector3a, vector3b));
        StdOut.println("Mult of matrix 3_2 and 2_3:");
        printMatrix(mult(matrix3_2, matrix2_3));
        StdOut.println("Mult of matrix 2_3 and 3_2:");
        printMatrix(mult(matrix2_3, matrix3_2));
        StdOut.println("Mult of matrix 3_2 and vector 2:");
        printMatrix(mult(matrix3_2, vector2));
        StdOut.println("Mult of vector 3a and matrix 3_2:");
        printMatrix(mult(vector3a, matrix3_2));
//        printMatrix();
    }
}
