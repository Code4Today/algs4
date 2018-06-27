public class EX01_01_11 {
    public static void printTwoDimBoolMatrix(boolean[][] matrix) {
        // calculate the rows and columns of matrix
        int rows = matrix.length;
        int cols = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i].length > cols) {
                cols = matrix[i].length;
            }
        }
//        int cols = matrix[0].length;
        int rows_bit = (int) Math.ceil(Math.log10(rows));
        int cols_bit = (int) Math.ceil(Math.log10(cols));
        if (0 == rows_bit) {
            rows_bit++;
        }
        if (0 == cols_bit) {
            cols_bit++;
        }
//        StdOut.printf("rows:%d rows_bit:%d cols:%d cols_bit:%d\n", rows, rows_bit, cols, cols_bit);
        
        // print the first line, include all column number
        StdOut.printf("%" + rows_bit + "s", " ");
        for (int i = 0; i < cols; i++){
            StdOut.printf(" %" + cols_bit + "d", i);
        }
        StdOut.print("\n");
        
        // print the following line, include line number and matrix line
        for (int i = 0; i < rows; i++) {
            StdOut.printf("%" + rows_bit + "d", i);
            for (int j = 0; j < matrix[i].length; j++) {
                StdOut.printf("%" + cols_bit + "s", " ");
                if (matrix[i][j]) {
                    StdOut.print("*");
                } else {
                    StdOut.print(" ");
                }
            }
            StdOut.print("\n");
        }
    }
    public static void main(String[] args) { 
        boolean[][] matrix1 = {{true}};
        boolean[][] matrix2 = {
            {true}, 
            {false, true, true, false, true, false, true, false,true, false, true, false, true, false}, 
            {true, true}, 
            {true, false}, 
            {true, false, true, true, false, true, false, true, false,true, false, true, false, true, false}, 
            {true, false}, 
            {true, false}, 
            {true, false}, 
            {true, false}, 
            {true, false}, 
            {true, false}};
        printTwoDimBoolMatrix(matrix2);
    }
}