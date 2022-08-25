// https://leetcode.com/problems/longest-increasing-subsequence/

package com.example.sdesheet.LeetCode.Aug22;

import java.util.*;

public class LongestIncreasingSubsequence {
	public int bisectLeft(List<Integer> res, int target) {
        int low = 0;
        int high = res.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (res.get(mid) == target)
                return mid;
            else if (target < res.get(mid))
                high = mid - 1;
            else 
                low = mid + 1;
        }
        
        return high + 1;
    }
    
    public int lengthOfLIS(int[] nums) {
        // Array to store the LIS
        List<Integer> res = new ArrayList<>();
        // We add the first element 
        res.add(nums[0]);
        
        int len = nums.length;
        // Create a variable to store the length of LIS and initialize it with 1
        int length = 1;
        // We traverse the list from index 1 and try to allocate them into 
        // result.
        for (int i = 1; i < len; i++) {
            // If the current number is less than the last element
            // we find the index of immediate greater element in the result 
            // array, and replace that with the current element.
            if (nums[i] <= res.get(res.size() - 1)) {
                int pos = bisectLeft(res, nums[i]);
                res.set(pos, nums[i]);
            }
            // Else we add the element to res and increase the length
            else {
                res.add(nums[i]);
                length++;
            }
        }
        
        return length;
    }
}