package sdesheet.Day12;

import java.util.*;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
        // Make a hashmap to store the elements and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        // a maxheap to store the elements based on decreading order of frequencies
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> (b.getValue() - a.getValue()));
        // add the elements
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            queue.offer(set);
        }
        
        int[] res = new int[k];
        int i = 0;
        // now pop out the first k elements from queue into result array
        while (i < k) {
            res[i++] = queue.poll().getKey();
        }
        
        return res;
    }
}