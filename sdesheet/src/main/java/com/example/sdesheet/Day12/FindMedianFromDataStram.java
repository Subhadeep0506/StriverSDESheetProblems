package com.example.sdesheet.Day12;

import java.util.*;

public class FindMedianFromDataStram {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(6);
        obj.addNum(10);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        obj.addNum(5);
        System.out.println(obj.findMedian());
    }
}

class MedianFinder {
    // To store left subarray
    PriorityQueue<Integer> maxHeap;
    // To store right subarray
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        
        // If the max of left subarray is grater than min of right subarray
        if (maxHeap.peek() != null && minHeap.peek()  != null && 
            maxHeap.peek() > minHeap.peek()) {
            // we take out that element and add it to minHeap
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        
        // If left subarray is much larger than right subarray, we move the max of 
        // left subarray to right subarray
        if (maxHeapSize > minHeapSize + 1) {
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }
        
        // If right subarray is much larger than left subarray, we move the min of 
        // right subarray to left subarray
        if (maxHeapSize + 1 < minHeapSize) {
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
    }
    
    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        
        // If both array size is same, we return the mean of max of left subarray 
        // and min of right subarray
        if (maxHeapSize == minHeapSize)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        
        // if left subarray is greater than right subarray, we return max of left subarray
        else if (maxHeapSize > minHeapSize)
            return maxHeap.peek();
        
        // else we return the min of right subarray
        else
            return minHeap.peek();
    }
}
