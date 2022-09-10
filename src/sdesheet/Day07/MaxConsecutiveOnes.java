/*
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 */

package sdesheet.Day07;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1)
                count++;
            else
                count = 0;
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}
