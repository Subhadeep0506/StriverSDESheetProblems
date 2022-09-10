/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int len = s.length();
        // int index = -1;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            }
            else {
                map.put(ch, i);
            }
        }
        
        for (int i: map.values()) {
            if (i != -1)
                return i;
        }
        
        return -1;
    }
}
