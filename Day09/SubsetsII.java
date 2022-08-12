/*
 * Given an integer array nums that may contain duplicates, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in any
 * order.
 * 
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

package Day09;

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    public void helper(int index, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans) {
        // Adding the new combination to answer
        ans.add(new ArrayList<>(ds));
        int len = nums.length;
        // Traversing all elements after the current element
        for (int i = index; i < len; i++) {
            // If we find any element same as the current element, we skip it
            if (i != index && nums[i] == nums[i - 1])
                continue;
            
            // we only add unique elements 
            ds.add(nums[i]);

            // Recur from next index
            helper(i + 1, nums, ds, ans);

            // Remove the element that was added here, as we don't want to use it again
            ds.remove(ds.size() - 1);
        }
    }
}
