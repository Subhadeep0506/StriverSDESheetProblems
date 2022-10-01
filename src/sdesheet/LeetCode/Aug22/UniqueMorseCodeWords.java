/*
 * https://leetcode.com/problems/unique-morse-code-words/
 * 
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class UniqueMorseCodeWords {
    private String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        int numOfWords = words.length;
        
        String encoded = "";
        Set<String> uniques = new HashSet<>();
        
        for (int i = 0; i < numOfWords; i++) {
            encoded = encodeToMorse(words[i]);
            uniques.add(encoded);
        }
        
        return uniques.size();
    }
    
    private String encodeToMorse(String s) {
        int len = s.length();
        String encoded = "";
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            encoded = encoded + morse[index];
        }
        
        return encoded;
    }
}
