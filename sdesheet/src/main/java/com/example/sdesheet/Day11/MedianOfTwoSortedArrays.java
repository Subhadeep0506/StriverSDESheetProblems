/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the
 * median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 */

package com.example.sdesheet.Day11;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        // We consider array with smaller length to be the split reference
        // So if 2nd array is smalle, we run the same function with
        // 2nd array and 1st array as arguments. 
        if (len1 > len2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = len1;
        int medianPos = ((len1 + len2) + 1) / 2; // Where the median of the merged array would be is calculated
        
        while (low <= high) {
            // A cut is made in the first array
            // If array is 2, 4, 9, 12
            // cut would be... |2|4|9|12|  ...here
            //                     ^
            int cut1 = (low + high) / 2;

            // And a similar cut is made in 2nd array
            // Consider 1, 3, 5, 9, 11 as 2nd array
            // MedianPosition would be |1|3|5|9|11|
            //                               ^
            int cut2 = medianPos - cut1;
            
            // If cut1 or cut2 is 0, l1 or l2 would be set t0 infinity
            // else l1 would be the immediate left elemnt of cut1 i.e. l1 = 4
            // and l2 would be immediate left of cut2 i.e. 5
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // if cut1 or cut2 is len1 or l2, r1 r2 will be set to negetive infinity
            // else r1 will be set to immediate right of cut1 i.e r1 = 9
            // r2 will be 9
            int r1 = (cut1 == len1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == len2) ? Integer.MAX_VALUE : nums2[cut2];
            
            // if l1 is less than or equal to r2 and
            // l2 is less than or equal to r1 then
            if (l1 <= r2 && l2 <= r1) {
                // if merged array is of evel length
                // median would be average of (max of l1 and l2) and min of r1 and r2
                if ((len1 + len2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                // else median would be max of l1 and l2
                else
                    return Math.max(l1, l2);
            }
            // if the l1 l2 r1 r2 condition is not satisfied
            // we move high and low accordingly
            else {
                if (l1 > l2)
                    high = cut1 - 1;
                else 
                    low = cut1 + 1;
            }
        }
        
        return 0.0;
    }
}
