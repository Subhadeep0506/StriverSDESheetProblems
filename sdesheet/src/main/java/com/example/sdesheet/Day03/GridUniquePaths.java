/*
* There is a robot on an m x n grid. The robot is initially located at the top-left
* corner (i.e., grid[0][0]). The robot tries
* to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only
* move either down or right at any point in
* time.
*/

package com.example.sdesheet.Day03;

public class GridUniquePaths {
    public static void main(String[] args) {
        int m = 7, n = 3;
        int paths = uniquePaths(m, n);
        System.out.println("No of unique possible paths: " + paths);
    }
  
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        
        return matrix[m - 1][n - 1];
    }
}