package sdesheet.DynamicProgramming;

import java.util.*;

class JumpingFrog {
	public static int frogJump(int n, int heights[]) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(n - 1, n, heights, memo);
    }
    
    private static int helper(int index, int n, int[] heights, int[] memo) {
        if (index == 0)
            return 0;
        
        if (memo[index] != -1)
            return memo[index];
        
        int one = helper(index - 1, n, heights, memo) + Math.abs(heights[index] - heights[index - 1]);
        int two = Integer.MAX_VALUE;
        if (index > 1)
            two = helper(index - 2, n, heights, memo) + Math.abs(heights[index] - heights[index - 2]);
        
        return (memo[index] = Math.min(one, two));
    }
}