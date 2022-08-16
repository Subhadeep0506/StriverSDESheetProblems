/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n
 * inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */

package com.example.sdesheet.Day02;

public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if (slow == fast)
                break;
        }
        
        fast = nums[0];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
