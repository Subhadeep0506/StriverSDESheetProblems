/*
 * Design a class to find the kth largest element in a stream. Note that it is the 
 * kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 1. KthLargest(int k, int[] nums) Initializes the object with the 
 * integer k and the stream of integers nums.
 * 2. int add(int val) Appends the integer val to the stream and returns the element 
 * representing the kth largest element in the stream.
 * 
 * Input:
 *  ["KthLargest", "add", "add", "add", "add", "add"]
 *  [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output:
 *  [null, 4, 5, 5, 8, 8]
 */

package neetcode.HeapPriorityQueue;

import java.util.*;

public class KThLargestInStream {
    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        
        for (int num : nums)
            add(num);
    }
    
    public int add(int val) {
        // If size of queue is less than k, add the element
        if (queue.size() < k)
            queue.offer(val);
        
        // if element is greater than last added element of queue, remove it and
        // add the new element
        else if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        // return the last element in queue
        return queue.peek();
    }
}