package sdesheet.Day12;

import java.util.*;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++){
            queue.add(nums[i]);
            if (queue.size() > k)
                queue.remove();
        }
        
        return queue.poll();
    }
}
