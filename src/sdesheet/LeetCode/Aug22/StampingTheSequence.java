/*
 * Link: https://leetcode.com/problems/stamping-the-sequence/
 * 
 * Solution explaination: https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100 
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[t.length];
        int stars = 0;
        
        while (stars < t.length) {
            boolean replaced = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && check(t, i, s)) {
                    stars = replace(t, i, s.length, stars);
                    visited[i] = true;
                    res.add(i);
                    replaced = true;
                    if (stars == t.length) {
                        break;
                    }
                }
            }
            
            if (!replaced) {
                return new int[0];
            }
        }
        
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(res.size() - i - 1);
        }
        return resArray;
    }
    
    private boolean check(char[] t, int p, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + p] != '*' && t[i + p] != s[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int replace(char[] t, int p, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (t[i + p] != '*') {
                t[i + p] = '*';
                count++;
            }
        }
        return count;
    }
}
