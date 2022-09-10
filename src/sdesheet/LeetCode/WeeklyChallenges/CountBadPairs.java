/*
	You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

	Return the total number of bad pairs in nums.

	Input: nums = [4,1,3,3]
	Output: 5
	Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
	The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
	The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
	The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
	The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
	There are a total of 5 bad pairs, so we return 5.

	Solution Explaination:
	1. First, instead of finding the number of pairs that are bad, we'll find the number of pairs that are not bad and subtract it from the total number of pairs.
	a. Remember, for an array of size n, there are exactly n * (n - 1) / 2 unique 
	pairs (i, j) where i < j. We get this from the sum of i from i = 1 to i = n.
	
	2. Then, consider the equation, j - i = nums[j] - nums[i]. The fact that we have two 
	unique indices i, j on both sides of this equation is frustrating. It'd be easier 
	if we could consider them individually. So, let's rearrange the equation using 
	basic algebra: j - nums[j] = i - nums[i]

*/

package sdesheet.LeetCode.WeeklyChallenges;

import java.util.*;

public class CountBadPairs {
	public long countBadPairs(int[] nums) {
        int len = nums.length;
        long totalPairs = (len * (len - 1L)) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            int val = map.getOrDefault(i - nums[i], 0);
            totalPairs = totalPairs - val;
            map.put(i - nums[i], val + 1);
        }
        
        return totalPairs;
    }
}