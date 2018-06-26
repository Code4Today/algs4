public class EX1_1_13 {
    public static void printTwoDimTransMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                StdOut.printf("%4d", matrix[j][i]);
            }
            StdOut.print("\n");
        }
    }
    public static void main(String[] args) { 
        int[][] matrix1 = {{1}};
        int[][] matrix2 = {
            {3, 5, 2}, 
            {6, 3, 2}, 
            {3, 5, 9}, 
            {7, 2, 4}};
        printTwoDimTransMatrix(matrix2);
    }
}