/*
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * 
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 */

package Day03;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0, high = (rows * cols) - 1;
        
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            
            if (matrix[mid / cols][mid % cols] == target)
                return true;
            else if (matrix[mid / cols][mid % cols] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }
}
