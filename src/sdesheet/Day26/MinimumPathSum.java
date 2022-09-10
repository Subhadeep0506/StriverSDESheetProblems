/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left 
 * to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */

package sdesheet.Day26;

import java.util.*;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] memo = new int[row][col];
        
        for (int[] r : memo)
            Arrays.fill(r, -1);
        
        return minPathSumMemo(row - 1, col - 1, grid, memo);
    }
    
    private int minPathSumMemo(int row, int col, int[][] grid, int[][] memo) {
        // If we are at destination
        if (row == 0 && col == 0)
            return grid[row][col];
        
        // If we cross boundries ,w ereturn 10^9
        // We cannot return Integer.MAX_VALUE because it will get added with
        // Some other path value, which will result in along value
        if (row < 0 || col < 0)
            return (int)1e9;
        
        // If path is already visited
        if (memo[row][col] != -1)
            return memo[row][col];
        
        // Next we find path sum for if we go up and left
        int up = grid[row][col] + minPathSumMemo(row - 1, col, grid, memo);
        int left = grid[row][col] + minPathSumMemo(row, col - 1, grid, memo);
        
        return memo[row][col] = Math.min(up, left);
    }

// --------------------------TABULATION--------------------------------
    
    public int minPathSumTabulation(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] tabu = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    tabu[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if (i > 0) up += tabu[i - 1][j];
                    else up = Integer.MAX_VALUE;
                    
                    int left = grid[i][j];
                    if (j > 0) left += tabu[i][j - 1];
                    else left = Integer.MAX_VALUE;
                    
                    tabu[i][j] = Math.min(up, left);
                }
            }
        }
        
        return tabu[row - 1][col - 1];
    }
}
