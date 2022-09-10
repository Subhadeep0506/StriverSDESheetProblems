package sdesheet.Day07;

import sdesheet.Day05.ListNode;

public class RotateListByK {
    public ListNode rotateRight(ListNode head, int k) {
        // if lsit is empty or has one element or k == 0
        // return head
        if (head == null || head.next == null || k == 0)
            return head;
        
        int len = 1;
        ListNode curr = head;
        // We traverse the list and count the number of elements
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        // We reach the last node at this moment
        // we point the next of last node to head, making the list 
        // circular
        curr.next = head;
        
        // reducing k
        k = k % len; // assume len = 5, k = k, k reduces to 3
        k = len - k; // we need to point len - k = 5 - 3 = 2nd node to null
        
        // We continue traversing the list from curr node
        while (k > 0) {
            curr = curr.next;
            // keep decreasing k, so that we reach the node that should point to null
            k--;
        }
        
        // now head of the list is changed
        head = curr.next;
        // and curr.next is set to null
        curr.next = null;
        
        return head;
    }
}
