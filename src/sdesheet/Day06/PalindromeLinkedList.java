package sdesheet.Day06;

import sdesheet.Day05.*;

public class PalindromeLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode nxt = null;
        while (head != null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = reverseList(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        
        while (slow != null) {
            if (dummy.val != slow.val)
                return false;
            
            dummy = dummy.next;
            slow = slow.next;
        }
        
        return true;
    }
}
