package LeetCode;

import java.util.HashMap;

public class MakingAlternatingArray {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        map.put(nums[1], 1);
        int count = 0;
        // int first = nums[0], second = nums[1];
        for (int i = 2; i < nums.length; i++) { // {3: 2, 1: 4}
            if (map.containsKey(nums[i])) { // [3, 1, 3, 1, 3, 1]
                if (map.get(nums[i]) == i - 1){
                    map.put(nums[i - 2], i);
                    count++;
                }
                else if (map.get(nums[i]) == i - 2) {
                    map.put(nums[i], i);
                }
            }
            else {
                map.put(nums[i - 2], i);
                count++;
            }
        }
        
        return count;
    }
}
