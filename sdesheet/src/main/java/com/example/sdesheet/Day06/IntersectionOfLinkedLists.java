/*
 * Given the heads of two singly linked-lists headA and headB, return the node at which
 * the two lists intersect. If the two linked lists have no intersection at all, return
 * null.
 */

package com.example.sdesheet.Day06;

import com.example.sdesheet.Day05.ListNode;

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if one of the list is empty
        if (headA == null || headB == null)
            return null;

        // starting by pointing 2 dummy nodes to heads of the lists
        ListNode dummyA = headA, dummyB = headB;

        // iterate while dummy nodes are not equal
        while (dummyA != dummyB) {
            // if we reach dummyA to null, point it to head of 2nd list and start move forward again, else move to next node
            dummyA = dummyA == null ? headB : dummyA.next;
            
            // same as above but moving dummyB to head of 1st list
            dummyB = dummyB == null ? headA : dummyB.next;
        }
        
        return dummyA;
    }
}
