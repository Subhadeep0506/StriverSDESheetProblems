/*
 * Given a collection of candidate numbers (candidates) and a target number (target)
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 */

package com.example.sdesheet.Day09;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public void helper(int index, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        // Base condition: If target is 0, add the ds
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        int len = candidates.length;
        for (int i = index; i < len; i++) {
            
            // If we encounter a duplicate candidate, we skip it.
            // As we don't want to add duplicates on same level
            if (i > index && (candidates[i] == candidates[i - 1]))
                continue;
            
            // If target is less than current candidate, we stop there
            if (target < candidates[i])
                break;
            
            ds.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
