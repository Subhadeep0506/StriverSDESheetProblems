// https://leetcode.com/problems/combination-sum-iv/

package sdesheet.LeetCode.Aug22;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] ds = new int[target + 1];
        Arrays.sort(nums);
        Arrays.fill(ds, -1);
        ds[0] = 1;
        return helper(nums, target, ds);
    }
    
    public int helper(int[] nums, int target, int[] ds) {
        if (ds[target] != -1)
            return ds[target];
        
        int len = nums.length;
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i], ds);
        }
        
        ds[target] = res;
        return res;
    }
}
