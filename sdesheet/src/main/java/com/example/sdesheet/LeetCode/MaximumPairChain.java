package com.example.sdesheet.LeetCode;

import java.util.Arrays;

public class MaximumPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};

        findLongestChain(pairs);
    }
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (pair1, pair2) -> (pair1[1] - pair2[1]));
        
        for (int[] pair: pairs)
            System.out.println(pair[0] + " " + pair[1]);

        int current = Integer.MIN_VALUE;
        int count = 0;
        
        for (int[] pair: pairs) {
            if (current < pair[0]) {
                current = pair[1];
                count++;
            }
        }
        return count;
    }
}
