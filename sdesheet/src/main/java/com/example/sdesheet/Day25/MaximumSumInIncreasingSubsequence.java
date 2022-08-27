/*
 * Given an array of n positive integers. Find the sum of the maximum sum 
 * subsequence of the given array such that the integers in the subsequence are 
 * sorted in strictly increasing order i.e. a strictly increasing subsequence.
 * 
 * Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
 * Output: 106
 * Explanation:The maximum sum of a
 * increasing sequence is obtained from
 * {1, 2, 3, 100}
 */

package com.example.sdesheet.Day25;

public class MaximumSumInIncreasingSubsequence {
    public int maxSumIS(int arr[], int n) {
	    int list[] = new int[n];
	    int maxSum = 0;
	    
        // fill the list with array elemnts
	    for (int i = 0; i < n; i++)
	        list[i] = arr[i];
	    
        // we start from 1st endex, and check every element before it with it.
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
                // If the elemnts before arr[i] is less than arr[i]
                // and list[i] is less than arr[i] + list[j]
	            if (arr[i] > arr[j] && list[i] < arr[i] + list[j]) {
	                list[i] = list[j] + arr[i];
	            }
	        }
	    }
	    
        // Find the max in list
	    for (int i = 0; i < n; i++)
	        maxSum = Math.max(maxSum, list[i]);
	    
	    return maxSum;
	}
}
