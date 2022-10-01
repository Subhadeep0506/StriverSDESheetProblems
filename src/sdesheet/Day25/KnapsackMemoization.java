package sdesheet.Day25;

import java.util.*;

public class KnapsackMemoization {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Create a dp matrix of size (n * w + 1)
        int[][] dp = new int[n][w + 1];
        
        // Fill dp with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        return helper(values, weights, n - 1, w, dp);
	}
    
    public static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int index, int w, int[][] dp) {
        // Basecase: When we reach the 1st element, we check if it can be added to
        // bag. If yes, we return the value of it, else return 0.
        if (index == 0) {
            int temp = weights.get(0);
            if (temp <= w) return values.get(0);
            else return 0;
        }
        
        // Checking dp for overlapping problems 
        if (dp[index][w] != -1)
            return dp[index][w];
        
        // Choice 1: We Don't take the item, and recur with next items
        int notTake = helper(values, weights, index - 1, w, dp);
        int take = Integer.MIN_VALUE;
        int currWeight = weights.get(index);
        // Choice 2: We take the item, and recur with next items
        if (currWeight <= w)
            take = values.get(index) + helper(values, weights, index - 1, w - currWeight, dp);
        
        // After recursion, we chose the max of values when item was taken and not 
        // taken, memoize it in dp
        return dp[index][w] = Math.max(take, notTake);
    }
}
