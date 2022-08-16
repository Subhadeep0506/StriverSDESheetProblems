/*
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 */

package com.example.sdesheet.Day09;

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0, s, res, path);
        return res;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) 
                return false;
        }
        
        return true;
    }
    
    public void helper(int index, String s, List<List<String>> res, List<String> path) {
        int len = s.length();
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = index; i < len; i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                helper(i + 1, s, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}