/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */

package sdesheet.Day07;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        // Initialize the array for resultant triplets
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        // consider a as each eleemnts till the 3rd last element
        for (int i = 0; i < len - 2; i++) {

            // if we are considering 1st element or we are considering an element we have not considered before
            // i.e element at i is not equal elemnt at i - 1
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1; // low at i + 1
                int high = len - 1; // high at end
                int sum = (0 - nums[i]); // b + c = 0 - a
                while (low < high) {

                    // if we find the right b-c pair, we add it to list
                    if (nums[low] + nums[high] == sum) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);
                        
                        // We ignore all next duplicate elements
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        // We ignore all duplicate elements left to elemnt at high
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    }
                    
                    // If the sum of b and c is lower than what we require, we increment low pointer
                    else if (nums[low] + nums[high] < sum)
                        low++;
                    // else we decrement high pointer
                    else 
                        high--;
                }
            }
        }
        
        return res;
    }
}
