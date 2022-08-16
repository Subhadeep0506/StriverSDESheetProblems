/*
 * Input:
 * N = 8
 * A[] = {15,-2,2,-8,1,7,10,23}
 * Output: 5
 * Explanation: The largest subarray with
 * sum 0 will be -2 2 -8 1 7.
 */

package com.example.sdesheet.Day04;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    int maxLen(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            }
            
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
