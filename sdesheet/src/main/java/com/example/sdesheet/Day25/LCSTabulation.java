package com.example.sdesheet.Day25;

public class LCSTabulation {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int curr[] = new int[m + 1];
        int prev[] = new int[m + 1];
        
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    curr[ind2] = 1 + prev[ind2 - 1];
                else
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
            }
            prev = (int[])curr.clone();
        }
        
        return prev[m];
    }
}
