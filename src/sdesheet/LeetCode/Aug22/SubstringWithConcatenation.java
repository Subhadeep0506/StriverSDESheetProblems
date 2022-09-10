/*
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        // Base case
        if (s == null || s.length() == 0 || words.length == 0 || words == null)
            return new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int len = s.length();
        int eachWordLen = words[0].length();
        int totWords = words.length;
        int totalWordLen = totWords * eachWordLen;
        
         List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= len - totalWordLen; i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            
             for (int j = 0; j < totWords; j++) {
                 int index = i + j * eachWordLen;
                 String word = s.substring(index, index + eachWordLen);
                 
                 if (!map.containsKey(word))
                     break;
                 
                 seen.put(word, seen.getOrDefault(word, 0) + 1);
                 
                 if (seen.get(word) > map.getOrDefault(word, 0))
                     break;
                 
                 if (j + 1 == totWords)
                     res.add(i);
             }
        }
        
        return res;
    }
}
