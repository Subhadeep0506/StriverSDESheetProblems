/*
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you
 * climb to the top?
 */

package com.example.neetcode.DynamicProgramming1D;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int prev = 1;
        int prePrev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = prev + prePrev;
            prePrev = prev;
            prev = curr;
        } 
        
        return curr;
    }
}

// The problem is similar to fibonacci series