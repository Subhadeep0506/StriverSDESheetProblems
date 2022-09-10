/*
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

package sdesheet.Day05;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null, next = null;
        
        while (head != null) {
            next = head.next;
            head.next = newNode;
            
            newNode = head;
            head = next;
        }
        
        return newNode;
    }
}
