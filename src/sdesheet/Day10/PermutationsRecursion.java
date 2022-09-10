/*
	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

	Input: nums = [1,2,3]
	Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

package sdesheet.Day10;

import java.util.*;

public class PermutationsRecursion {
	public List<List<Integer>> permute(int[] nums) {
        // List to store all permutations
        List<List<Integer>> ans = new ArrayList<>();
        // List to store each permutation
        List<Integer> ds = new ArrayList<>();
        int len = nums.length;
        // Frequency array of size of nums, to hash the usage of each element
        boolean[] freq = new boolean[len];
        Arrays.fill(freq, false); // Fills freq array with false
        helper(nums, ans, ds, freq);
        return ans;
    }
    
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
        int len = nums.length;
        // if each permutation is completed
        if (ds.size() == len) {
            // add it
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < len; i++) {
            // if element is not used
            if (!freq[i]) {
                // mark it used...
                freq[i] = true;
                // ...and use it
                ds.add(nums[i]);
                helper(nums, ans, ds, freq);
                // again mark it unused after recursion (backtracking)
                freq[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }
}