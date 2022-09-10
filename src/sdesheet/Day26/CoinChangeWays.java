/*
 * We are given an array Arr with N distinct coins and a target. We have an 
 * infinite supply of each coin denomination. We need to find the number of ways we 
 * sum up the coin values to give us the target.
 * 
 * coins = [1, 2, 3] target = 4
 * ways = 4 -> ([1 1 1 1], [1 1 2], [1 3], [2 2])
 */

package sdesheet.Day26;

import java.util.*;

public class CoinChangeWays {
    public static void main(String[] args) {
        int coins[] ={1,2,3};
        int amount=4;

        System.out.println(countWaysToMakeChangeTabu(coins, amount));
    }

    public static long countWaysToMakeChangeMemo(int coins[], int amount){
        int n = coins.length;
        // create a memo matrix of size (n * target + 1)
        long[][] memo = new long[n][amount + 1];
        // Fill it with -1
        for (long[] row : memo)
            Arrays.fill(row, -1);
        
        return helper(n - 1, amount, coins, memo);
	}
    
    private static long helper(int index, int amount, int[] coins, long[][] memo) {
        // Base case
        // If we are at last coin, we have 2 choice here
        if (index == 0) {
            // If the amount is divisable by last coin, we take it
            if (amount % coins[0] == 0)
                return 1;
            // Else we don't take it.
            else
                return 0;
        }
        
        // If the problem was visited before, we return it 
        if (memo[index][amount] != -1)
            return memo[index][amount];
        
        // Two choices.
        // Either we don't consider the current coin 
        long notTake = helper(index - 1, amount, coins, memo);
        // Or we do
        long take = 0;
        
        // If we consider the current coin, We check if it is smaller than the 
        // target amount. If yes only then we take it 
        if (coins[index] <= amount)
            take = helper(index, amount - coins[index], coins, memo);
        
        // Lastly, we sum the take and not take cases and memoize it.
        return memo[index][amount] = take + notTake;
    }

    //-------------------------TABULATION-------------------------------------

    public static long countWaysToMakeChangeTabu(int coins[], int amount){
        int n = coins.length;
        long[][] memo = new long[n][amount + 1];
        
        // base condition
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                memo[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                long notTake = memo[i - 1][j];
                long take = 0;
                if (coins[i] <= j)
                    take = memo[i][j - coins[i]];
                memo[i][j] = take + notTake;
            }
        }
        
        return memo[n - 1][amount];
	}

    // -------------------SPACE OPTIMIZED--------------------------------
    public static long countWaysToMakeChangeOptimized(int coins[], int amount){
        int n = coins.length;
        long[] prev = new long[amount + 1];
        
        // base condition
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            long[] curr = new long[amount + 1];
            for (int j = 0; j <= amount; j++) {
                long notTake = prev[j];
                long take = 0;
                if (coins[i] <= j)
                    take = curr[j - coins[i]];
                curr[j] = take + notTake;
            }
            prev = curr;
        }
        
        return prev[amount];
	}
}
