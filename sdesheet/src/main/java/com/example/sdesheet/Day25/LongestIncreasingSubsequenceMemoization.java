/*
 * Given an integer array nums, return the length of the longest strictly increasing 
 * subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or 
 * no
 * elements without changing the order of the remaining elements. For example, 
 * [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */

package com.example.sdesheet.Day25;

import java.util.*;

public class LongestIncreasingSubsequenceMemoization {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        
        for (int[] row : dp) 
            Arrays.fill(row, -1);
        
        return helper(nums, n, 0, -1, dp);
    }
    
    private int helper(int[] nums, int n, int index, int prev, int[][] dp) {
        // If we have reached end of array, no more possible length
        if (index == n) 
            return 0;
        
        // If the subproblem was solved already, return the answer prom table
        if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];
        
        int notTake = helper(nums, n, index + 1, prev, dp);
        int take = 0;
        
        if (prev == -1 || nums[index] > nums[prev]) {
            take = 1 + helper(nums, n, index + 1, index, dp);
        }
        
        return dp[index][prev + 1] = Math.max(take, notTake);
    }
}
