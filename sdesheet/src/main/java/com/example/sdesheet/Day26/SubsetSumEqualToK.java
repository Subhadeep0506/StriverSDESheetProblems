/*
 * We are given an array ‘ARR’ with N positive integers. We need to find if there 
 * is a subset in “ARR” with a sum equal to K. If there is, return true else return 
 * false.
 * 
 * i/p - {1, 2, 3, 4}
 * k = 4
 * 
 * o/p = {1, 3}; {4}
 */

package com.example.sdesheet.Day26;

import java.util.*;

public class SubsetSumEqualToK {
    public static boolean subsetSumToKMemo(int n, int k, int arr[]){
        // Initialize a 2d array of size (n * k + 1)
        boolean memo[][] = new boolean[n][k + 1];
        // fill the array with false
        for (boolean[] row : memo)
            Arrays.fill(row, false);
        // call the recursive function
        return helper(n - 1, k, arr, memo);
    }
    
    private static boolean helper(int n, int k, int[] arr, boolean[][] memo) {
        // Base cases
        // If our target sum is 0, this means we have formed our required
        // array, so we return true.
        if (k == 0)
            return true;
        // When we have reached index 0, we return whether that elemnt
        // is equal to our current target. 
        if (n == 0)
            return k == arr[0];
        
        // If we find any previously solved problem we return it
        if (memo[n][k])
            return memo[n][k];
        
        // Case 1: we don't take the current element
        boolean notTake = helper(n - 1, k, arr, memo);
        boolean take = false;
        // We take the current elemnt only if it is smaller than 
        // or equal to target
        if (arr[n] <= k)
            take = helper(n - 1, k - arr[n], arr, memo);
        
        // We store true in the memo if either by taking or not taking
        // the element solved our problem
        memo[n][k] = (notTake || take);
        return notTake || take;
    }

    // --------------------------TABULATION----------------------------------
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Initialize a 2d array of size (n * k + 1)
        boolean memo[][] = new boolean[n][k + 1];

        // all the targets with 0 should be true
        for (int i = 0; i < n; i++)
            memo[i][0] = true;
        
        // if arr[0] <= k, this means that arr[0] can be an answer
        // So we fill arr[0] with target 0 as true in memo
        if (arr[0] <= k)
            memo[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean notTake = memo[i - 1][j];
                boolean take = false;
                
                if (arr[i] <= j)
                    take = memo[i - 1][j - arr[i]];
                
                memo[i][j] = (take || notTake);
            }
        }
        return memo[n - 1][k];
    }
}
