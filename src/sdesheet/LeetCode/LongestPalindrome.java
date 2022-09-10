package sdesheet.LeetCode;

import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int maxOddLength = 0;
        int count = 0;
        
        for (Map.Entry<Character, Integer> set: map.entrySet()) {
            if (set.getValue() % 2 != 0) {
                maxOddLength = Math.max(maxOddLength, set.getValue());
            }
            else if (set.getValue() % 2 == 0)
                count += set.getValue();
        }
        
        return count + maxOddLength;
    }
}
