/*
 * Input: s = "abcabcbb" 
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

package com.example.sdesheet.Day04;

import java.util.HashMap;

public class LogestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        if (s.length() == 0)
            return 0;
        
        s.toLowerCase();
        int start = 0, end = 0;
        int maxLength = 0;
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { //"abba" 
            // character exists
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            end++;
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, (end - start));
        }
        
        return maxLength;
    }
}
