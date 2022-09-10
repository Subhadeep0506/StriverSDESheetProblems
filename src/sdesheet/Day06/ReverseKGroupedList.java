/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, and
 * return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list
 * If the number of nodes is not a multiple of k then left-out nodes, in the end,
 * should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may be
 * changed.
 */

package sdesheet.Day06;

import sdesheet.Day05.ListNode;

public class ReverseKGroupedList {
    public int getListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // if list is empty or has just one element, return head
        if (head == null || head.next == null)
            return head;

        // get the length of the list
        int length = getListLength(head);
        
        // Dummy node to store head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // initializing pre node to dummy
        ListNode pre = dummy;
        ListNode curr;
        ListNode nex;
        
        // Iterate until k is < length
        while (length >= k) {
            curr = pre.next;
            nex = curr.next;

            // iterate for k - 1 elements 
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            
            pre = curr;
            length -= k;
        }
        
        return dummy.next;
    }
}
