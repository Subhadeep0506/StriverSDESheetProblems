/*
	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

	Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

package sdesheet.Day10;

import java.util.*;

public class PermutationsBacktracking {
	public List<List<Integer>> permute(int[] nums) {
        // List to store all permutations
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans);
        return ans;
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void helper(int index, int[] nums, List<List<Integer>> ans) {
        int len = nums.length;
        // if each permutation is completed
        if (index == len) {
            ArrayList<Integer> ds = new ArrayList<>();
            for (int num: nums)
                ds.add(num);
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = index; i < len; i++) {
            swap(i, index, nums);
            helper(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
}