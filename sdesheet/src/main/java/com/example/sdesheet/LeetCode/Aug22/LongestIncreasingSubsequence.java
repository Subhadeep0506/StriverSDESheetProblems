// https://leetcode.com/problems/longest-increasing-subsequence/

package com.example.sdesheet.LeetCode.Aug22;

import java.util.*;

public class LongestIncreasingSubsequence {
	public int bisectLeft(ArrayList<Integer> res, int target) {
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
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        
        int len = nums.length;
        int length = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= res.get(res.size() - 1)) {
                int pos = bisectLeft(res, nums[i]);
                res.set(pos, nums[i]);
            }
            else {
                res.add(nums[i]);
                length++;
            }
        }
        
        return length;
    }
}