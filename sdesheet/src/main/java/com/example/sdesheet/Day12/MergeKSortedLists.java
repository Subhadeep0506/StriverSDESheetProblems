package com.example.sdesheet.Day12;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        // Add the three nodes to the queue
        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }
        
        // unless the queue isnt empty
        while (!queue.isEmpty()) {
            // Poll the 1st element from queue add attach it to curr's next
            curr.next = queue.poll();
            
            // move curr pointer
            curr = curr.next;
            
            // if the curr pointer has a next element, add it to queue
            if (curr.next != null)
                queue.offer(curr.next);
        }
        
        return head.next;
    }
}
