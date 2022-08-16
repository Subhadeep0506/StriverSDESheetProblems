// https://leetcode.com/problems/binary-trees-with-factors/
/*
	arr = [2,4,5,10]

	dp = [1, 1, 1, 1] 
	// all elements of DP table are 1 because every element of the array without any children is a tree in itself

	i = 0, j = 0
	// Wont run becoz j < i -> false
	------------------------------
	i = 1, j = 0

	arr[i] = 4, arr[j] = 2
	arr[i] % arr[j] == 0 - true
	rem = arr[i] / arr[j] = 4 / 2 = 2
	dp[i] = 1, dp[j] = 1
	dp[i] += dp[j] * dp[map.get(rem)] = 1 * 1 = 1
	dp[i] = dp[i] + 1 = 2
	dp = [1, 2, 1, 1] 
	-------------------------------

	i = 2, j = 0

	arr[i] = 5, arr[j] = 2
	arr[i] % arr[j] == 0 - false

	i = 2, j = 1

	arr[i] = 5, arr[j] = 4
	arr[i] % arr[j] == 0 - false
	-------------------------------

	i = 3, j = 0

	arr[i] = 10, arr[j] = 2
	arr[i] % arr[j] == 0 - true
	rem = arr[i] / arr[j] = 10 / 2 = 5
	dp[i] = 1, dp[j] = 1
	dp[i] += dp[j] * dp[map.get(rem)] = 1 * 1 = 1
	dp[i] = dp[i] + 1 = 2
	------ dp = [1, 2, 1, 2] ------ 

	i = 3, j = 1

	arr[i] = 10, arr[j] = 4
	arr[i] % arr[j] == 0 - false

	i = 3, j = 2

	arr[i] = 10, arr[j] = 5
	arr[i] % arr[j] == 0 - true
	rem = arr[i] / arr[j] = 10 / 5 = 2
	dp[i] = 2, dp[j] = 1
	dp[i] += dp[j] * dp[map.get(rem)] = 1 * 1 = 1
	dp[i] = dp[i] + 1 = 2 + 1 = 3
	------ dp = [1, 2, 1, 3] ---------- 
*/
package com.example.sdesheet.LeetCode.Aug22;

import java.util.*;

public class BinaryTreesWithFactors {
	public int numFactoredBinaryTrees(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return 1;
        long dp[] = new long[len];
        Arrays.fill(dp ,1);
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int rem = arr[i] / arr[j];
                    if (map.containsKey(rem))
                        dp[i] += dp[j] * dp[map.get(rem)];
                }
            }
        }
        
        long counts = 0;
        for (long count: dp)
            counts += count;
        
        return (int) (counts % 1000000007);
    }
}