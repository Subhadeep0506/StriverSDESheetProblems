package sdesheet.Day13;

import java.util.*;

public class NextGreaterElement {
	public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len])
                stack.pop();
            
            if (i < len) {
                if (!stack.isEmpty()) {
                    res[i] = stack.peek();
                }
                else {
                    res[i] = -1;
                }
            }
            
            stack.push(nums[i % len]);
        }
        
        return res;
    }
}