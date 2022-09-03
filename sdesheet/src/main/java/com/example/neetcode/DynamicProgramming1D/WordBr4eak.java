/*
 * Given a string s and a dictionary of strings wordDict, return true if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the 
 * segmentation.
 */

package com.example.neetcode.DynamicProgramming1D;

import java.util.*;

public class WordBr4eak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        
        boolean[] memo = new boolean[len + 1];
        
        memo[len] = true;
        
        for (int i = len - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i + wordLen <= len && s.substring(i, wordLen + i).equals(word)) {
                    memo[i] = memo[i + wordLen];
                }
                if (memo[i])
                    break;
            }
        }
        
        return memo[0];
    }
}
