/*
 * Input: head = [1,2,3,4,5] 
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */

package com.example.sdesheet.Day05;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        int mid = count / 2 ;
        count = 0;
        curr = head;
        while (count != mid) {
            count++;
            curr = curr.next;
        }
        
        return curr;
    }
}
