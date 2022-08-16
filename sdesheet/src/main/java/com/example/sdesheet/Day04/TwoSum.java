package com.example.sdesheet.Day04;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (tracker.containsKey(nums[i])) {
                int key = tracker.get(nums[i]);
                return new int[]{key, i};
            }
            else {
                tracker.put(target - nums[i], i);
            }
        }
        
        return new int[]{};
    }
}
