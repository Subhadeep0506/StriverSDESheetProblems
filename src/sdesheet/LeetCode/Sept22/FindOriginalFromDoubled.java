package sdesheet.LeetCode.Sept22;

import java.util.*;

public class FindOriginalFromDoubled {
	public int[] findOriginalArray(int[] changed) {
        int size = changed.length;
        int[] res = new int[size / 2];
        // If array is of even sized, it is invalid, so return empty array
        if (size % 2 != 0)
            return new int[0];
        // Sort the array
        Arrays.sort(changed);
        // Map to store element and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        
        int count = 0;
        // Loop over every element
        for (int num : changed) {
            int numDouble = num * 2;
            // If current element frequency is below 1, we go to next element
            if (map.get(num) < 1)
                continue;
            // If the double of current element dont exist, we return empty array.
            // As it will be invalid answer
            if (map.getOrDefault(numDouble, 0) < 1)
                return new int[0];
            // Decrease frequencies of current element and its double
            map.put(num, map.get(num) - 1);
            map.put(numDouble, map.get(numDouble) - 1);
            // Add current element to result array
            res[count++] = num;
        }
        return res;
    }
}