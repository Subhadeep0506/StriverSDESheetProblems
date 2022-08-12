/*
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates
 * in-place such that each unique element appears only once. The relative order of the
 * elements should be kept the same.
 */

package Day07;

public class RemoveDuplicatedFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        int len = nums.length;
        int count = 1;
        while (j < len) {
            if (nums[i] == nums[j])
                j++;
            else {
                i++;
                nums[i] = nums[j];
                count++;
            }                
        }
        
        return count;
    }
}
