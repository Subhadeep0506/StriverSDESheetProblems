package sdesheet.LeetCode.Aug22;

import java.util.*;

public class RansomNote {
    // Using HashMap
    public boolean canConstructWithMap(String ransomNote, String magazine) {
        int magazineLen = magazine.length();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < magazineLen; i++) {
            char c = magazine.charAt(i);
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        
        int noteLen = ransomNote.length();
        if (magazineLen < noteLen)
            return false;
        
        for (int i = 0; i < noteLen; i++) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) 
                return false;
            
            int val = map.get(c);
            map.put(c, val - 1);
        }
        
        return true;
    }

    // Using a chaarcters array to store the frequency of each character.
    public boolean canConstruct(String ransomNote, String magazine) {
        int magazineLen = magazine.length();
        int noteLen = ransomNote.length();
        
        if (magazineLen < noteLen)
            return false;
        
        int[] vault = new int[26];
        for (int  i = 0; i < magazineLen; i++) 
            vault[magazine.charAt(i) - 'a']++;
        
        for (int i = 0; i < noteLen; i++){
            if (vault[ransomNote.charAt(i) - 'a'] == 0)
                return false;
            
            vault[ransomNote.charAt(i) - 'a']--;
        }
        
        return true;
    }
}
