/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers 
 * and n, representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be stored inside the
 * array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the
 * elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2
 * has a length of n.
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */

package sdesheet.Day02;

public class MergeSortedArrays {
    int[] num1 = {1, 2, 3, 0, 0, 0};
    int[] num2 = {2, 5, 6};
    int m = 3, n = 3;
    public static void main(String[] args) {
        MergeSortedArrays obj = new MergeSortedArrays();

        merge(obj.num1, obj.m, obj.num2, obj.n);

        for (int num: obj.num1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1;
        int cursor = m + n - 1;
        // we start from the end of both the nums
        while (tail1 >= 0 && tail2 >= 0) {
            // We store the max of the num1 and num2 element at tail1 and tail2 index to num1 at cursor
            // simultenously decrementing cursor and either tail1 or tail2
            nums1[cursor--] = nums1[tail1] >= nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }
        
        // copying remaining num2 values if remaining
        while (tail2 >= 0) {
            nums1[cursor--] = nums2[tail2--];
        }
    }
}
