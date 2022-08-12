/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 */

package Day01;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println("Max sum of subarray: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int lastLargestSum = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            lastLargestSum += nums[i];
            if (lastLargestSum > largestSum)
                largestSum = lastLargestSum;
            if (lastLargestSum < 0)
                lastLargestSum = 0;
        }

        return largestSum;
    }
}