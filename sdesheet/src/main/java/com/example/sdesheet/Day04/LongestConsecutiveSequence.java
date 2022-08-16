package com.example.sdesheet.Day04;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        
        int length = nums.length;
        
        if (length == 0)
            return 0;
        
        int count = 1, longestCount = 1;
        for (int i = 1; i < length; i++) {
            // if next number is consecutive
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            }
            else if (nums[i] != nums[i - 1])  {
                count = 1;
            }
            longestCount = Math.max(longestCount, count);
        }
        
        return longestCount;
    }
}
