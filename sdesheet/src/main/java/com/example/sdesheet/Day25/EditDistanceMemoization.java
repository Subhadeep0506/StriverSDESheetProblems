/*
 * Given two strings word1 and word2, return the minimum number of operations 
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */

package com.example.sdesheet.Day25;

import java.util.*;

public class EditDistanceMemoization {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n][m];
        for (int row[]: dp) 
            Arrays.fill(row, -1);
        
        return helper(word1, word2, n - 1, m - 1, dp);
    }
    
    private int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = helper(s1, s2, i - 1, j - 1, dp);
        
        else 
            return dp[i][j] = 1 + Math.min(helper(s1, s2, i - 1, j - 1, dp),
                                      Math.min(
        helper(s1, s2, i - 1, j, dp), helper(s1, s2, i, j - 1, dp)));
    }
}
