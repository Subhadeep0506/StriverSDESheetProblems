package com.example.sdesheet.Day25;

public class MatrixChainTabulation {
    static int matrixMultiplication(int N, int arr[]) {
        // Initialize a dp matrix with diagonals to 0
        // This means, dp[i][j] == 0, where i == j.
        // Because dp[i][j] means minimum no of steps required to multiply
        // matrices i to j. When matrices are same, we need 0 steps
        int dp[][] = new int[N][N];
        for (int i = 1; i < N; i++)
            dp[i][i] = 0;
        
        for (int i = N - 1; i > 0; i--) {
            for (int j = i + 1; j < N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + 
                        dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                
                dp[i][j] = min;
            }
        }
            
        return dp[1][N - 1];
    }
}
