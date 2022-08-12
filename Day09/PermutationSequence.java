/*
	The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order, we get the 
	following sequence for n = 3:

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.

	Input: n = 3, k = 3
	Output: "213"
*/

package Day09;

import java.util.*;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        
        // Calculating the factorial upto n - 1, and adding the number
        for (int i = 1; i < n; i++) {
            fact *= i;  
            nums.add(i);
        }
        String res = "";
        // Adding the last number
        nums.add(n);
        // Reducing k because we consider 0 based indexing
        k = k - 1;
        while (true) {
            res += nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.size() == 0)
                break;
            k = k % fact;
            fact = fact / nums.size();
        }
        
        return res;
    }
}