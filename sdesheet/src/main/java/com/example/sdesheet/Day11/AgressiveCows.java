/*
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The 
 * stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,
 * 000,000).
 * 
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive 
 * towards each other once put into a stall. To prevent the cows from hurting each 
 * other, FJ wants to assign the cows to the stalls, such that the minimum distance 
 * between any two of them is as large as possible. What is the largest minimum 
 * distance?
 */

package com.example.sdesheet.Day11;

import java.util.*;

public class AgressiveCows {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 1; i <= count; i++) {
			int n = sc.nextInt();
			int cows = sc.nextInt();
			int[] stalls = new int[n];
			
			for (int j = 0; j < n; j++) {
				stalls[j] = sc.nextInt();
			}
			
			aggressiveCows(stalls, n, cows);
		}
        sc.close();
	}
	
	public static void aggressiveCows(int[] stalls, int n, int cows) {
		Arrays.sort(stalls);
		
		int low = 1, high = stalls[n - 1] - stalls[0];
        int res = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isPossible(stalls, n, cows, mid)) {
                res = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		System.out.println(res);
	}
	
	public static boolean isPossible(int[] stalls, int n, int c, int mid) {
		int count = 1;
		int lastPlaced = stalls[0];
		
		for (int i = 1; i < n; i++) {
			if (stalls[i] - lastPlaced >= mid) {
				count++;
				lastPlaced = stalls[i];
                if (count >= c)
			        return true;
			}
		}
		return false;
	}
}

