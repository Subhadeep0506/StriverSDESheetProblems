/*
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class ReduceArraySizeToTheHalf {
    // HashMap and sorting
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        
        // Putting the frequency of each element into the hashmap
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> freqArr = new ArrayList<>();
        for (int num: map.values()) {
            freqArr.add(num);
        }
        
        Collections.sort(freqArr);
        // Given the array length is even
        int half = len / 2;
        int count = 0;
        int length = freqArr.size();
        for (int i = length - 1; i >= 0; i--) {
            half -= freqArr.get(i);
            count++;
            if (half <= 0)
                return count;
        }
        
        return count;
    }
}
