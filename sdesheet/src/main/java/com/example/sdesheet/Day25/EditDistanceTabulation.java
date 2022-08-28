package com.example.sdesheet.Day25;

public class EditDistanceTabulation {
	public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < m + 1; i++)
            dp[0][i] = i;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        
        return dp[n][m];
    }

    public int minDistanceOptimized(String word1, String word2) {
    	int n = word1.length();
        int m = word2.length();
        
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        
        for (int i = 0; i < m + 1; i++)
            prev[i] = i;
        
        for (int i = 1; i < n + 1; i++) {
            curr[0] = i;
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
            }
            prev = (int[])(curr.clone());
        }
        
        return prev[m];
    }
}