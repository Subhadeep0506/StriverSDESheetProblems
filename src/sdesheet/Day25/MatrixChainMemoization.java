/*
 * Given a sequence of matrices, find the most efficient way to multiply these 
 * matrices together. The efficient way is the one that involves the least number 
 * of multiplications.
 * 
 * The dimensions of the matrices are given in an array arr[] of size N (such that 
 * N = number of matrices + 1) where the ith matrix has the dimensions 
 * (arr[i-1] * arr[i]).
 */

package sdesheet.Day25;

import java.util.*;

public class MatrixChainMemoization {
    public static int matrixMultiplication(int N, int arr[]) {
        // Memo array
        int memo[][] = new int[N][N];
        
        for (int[] row : memo)
            Arrays.fill(row, -1);
            
        return helper(1, N - 1, arr, memo);
    }
    
    public static int helper(int i, int j, int[] arr, int[][] memo) {
        // When we select only one matrix, it will not be 
        // multiplied with anyone. So 0 will be returned
        if (i == j)
            return 0;
            
        // When we have some answer in memo[i][j]
        if (memo[i][j] != -1)
            return memo[i][j];
            
        int min = Integer.MAX_VALUE;
        // For each partitions we calculate minimum stps
        for (int k = i; k < j; k++) {
            // Calculate steps for current partition
            // and for other partitions
            int steps = (arr[i - 1] * arr[k] * arr[j]) + 
                helper(i, k, arr, memo) + helper(k + 1, j, arr, memo);
            // Store the minimum of them
            min = Math.min(steps, min);
        }
        // Upadate memo
        return memo[i][j] = min;
    }
}
