package com.example.sdesheet.Day26;

import java.util.*;

public class RodCutting {
    public static int cutRodMemo(int price[], int n) {
		// Write your code here.
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        return helper(n - 1, n, price, memo);
	}
    
    private static int helper (int index, int length, int[] price, int[][] memo) {
        if (index == 0)
            return price[index] * length;
        
        if (memo[index][length] != -1)
            return memo[index][length];
        
        int notTake = helper(index - 1, length, price, memo);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= length)
            take = price[index] + helper(index, length - rodLength, price, memo);
        
        return memo[index][length] = Math.max(take, notTake);
    }

    // ---------------------------TABULATION----------------------------------
    public static int cutRodTabu(int price[], int n) {
        // Write your code here.
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        for (int i = 0; i <= n; i++) 
            memo[0][i] = price[0] * i;
        
        for (int index = 1; index < n; index++) {
            for (int length = 0; length <= n; length++) {
                int notTake = memo[index - 1][length];
                int take = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if (rodLength <= length)
                    take = price[index] + memo[index][length - rodLength];
                
                memo[index][length] = Math.max(take, notTake);
            }
        }
        
        return memo[n - 1][n];
    }

    // ----------------SPACE OPTIMIZED------------------------------
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int[] curr = new int[n + 1];
        
        for (int i = 0; i <= n; i++) 
            curr[i] = price[0] * i;
        
        for (int index = 1; index < n; index++) {
            for (int length = 0; length <= n; length++) {
                int notTake = curr[length];
                int take = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if (rodLength <= length)
                    take = price[index] + curr[length - rodLength];
                
                curr[length] = Math.max(take, notTake);
            }
        }
        
        return curr[n];
    }
}
