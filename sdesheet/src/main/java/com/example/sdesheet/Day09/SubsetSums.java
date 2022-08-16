/*
 * Given a list arr of N integers, print sums of all subsets in it.
 * 
 * Input:
 * N = 2
 * arr[] = {2, 3}
 * 
 * Output:
 * 0 2 3 5
 */

package com.example.sdesheet.Day09;

import java.util.*;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> subset = new ArrayList<>();
        helper(0, 0, subset, N, arr);
        Collections.sort(subset);
        return subset;
    }
    
    void helper(int index, int sum, ArrayList<Integer> subset, int N, ArrayList<Integer> arr) {
        if (index == N) {
            subset.add(sum);
            return;
        }
        
        // Taking the element
        helper(index + 1, sum + arr.get(index), subset, N, arr);
        
        // Not taking the element
        helper(index + 1, sum, subset, N, arr);
    }
}
