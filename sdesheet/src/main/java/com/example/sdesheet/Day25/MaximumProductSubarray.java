/*
 * Given an integer array nums, find a contiguous non-empty subarray within the 
 * array that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 */

package com.example.sdesheet.Day25;

public class MaximumProductSubarray {
    public static void main(String args[]) {
        int arr[] = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] arr) {
        int res = arr[0];
        int currMax = res, currMin = res;
        int len = arr.length;
        
        for (int i = 1; i < len; i++) {
            int currMaxProd = currMax * arr[i];
            int currMinProd = currMin * arr[i];
            
            currMax = Math.max(arr[i], Math.max(currMaxProd, currMinProd));
            currMin = Math.min(arr[i], Math.min(currMaxProd, currMinProd));
            
            res = Math.max(res, currMax);
        }
        
        return res;
    }
}
