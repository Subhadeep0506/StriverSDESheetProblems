package sdesheet.Day25;

import java.util.*;

public class KnapsackTabulation {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        int[][] dp = new int[n][w + 1];
        for (int  i = weights.get(0); i <= w; i++) {
            dp[0][i] = values.get(0);
        }
        
        for (int index = 1; index < n; index++) {
            for (int cap = 0; cap <= w; cap++) {
                int notTake = dp[index - 1][cap];
                
                int take = Integer.MIN_VALUE;
                if (weights.get(index) <= cap)
                    take = values.get(index) + dp[index - 1][cap - weights.get(index)];
                
                dp[index][cap] = Math.max(take, notTake);
            }
        }
        
        return dp[n - 1][w];
	}

    public static int knapsackSpaceOptimized(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int prev[] = new int[w + 1];

        for (int i = weights.get(0); i <= w; i++) {
            prev[i] = values.get(0);
        }

        for (int index = 1; index < n; index++) {
            for (int cap = w; cap >= 0; cap--) {
                int notTake = prev[cap];
                int take = Integer.MIN_VALUE;
                if (weights.get(index) <= cap)
                    take = values.get(index) + prev[cap - weights.get(index)];
                prev[cap] = Math.max(notTake, take);
            }
        }

        return prev[w];
    }
}
