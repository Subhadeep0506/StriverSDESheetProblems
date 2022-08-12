/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 
 * 0's.
 */

package Day01;

public class SetMatrixZero {
    int[][] matrix = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};
    public static void main(String[] args) {
        SetMatrixZero obj = new SetMatrixZero();
        setZeros(obj.matrix);

        for (int i[]: obj.matrix) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] matrix) {
        boolean isColumn = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // We will traverse the matrix linearly
        for (int i = 0; i < rows; i++) {
            // if elemnt of 1st column of ith row is 0
            if (matrix[i][0] == 0)
                isColumn = true;
            for (int j = 1; j < cols; j++){
                // if element at ith row: jth col is 0
                if (matrix[i][j] == 0){
                    // set the leftmost elemnt on the row to 0
                    matrix[i][0] = 0;
                    // set the topmost elemnt on the col to 0
                    matrix[0][j] = 0;
                }
            }
        }

        // traversing the matrix backwards
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) 
                    matrix[i][j] = 0;
            }
            // if any elemnt in the 1st column is 0 i.e. isColumn == true
            if (isColumn)
                matrix[i][0] = 0;
        }
    }
}