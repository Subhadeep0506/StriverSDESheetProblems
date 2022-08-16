/*
 * A linked list of length n is given such that each node contains an additional random
 * pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand
 * new nodes, where each new node has its value set to the value of its corresponding 
 * original node. Both the next and random pointer of the new nodes should point to new 
 * nodes in the copied list such that the pointers in the original list and copied list 
 * represent the same list state. None of the pointers in the new list should point to 
 * nodes in the original list.
 * 
 * For example, if there are two nodes X and Y in the original list, where X.random --> 
 * Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 */

package com.example.sdesheet.Day07;

import java.util.*;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        
        // We traverse each node from head
        while (curr != null) {
            // Take the ith node and put it into the hash map as key
            // make a copy of that node only using it's data(val) and put that copy node as value for the key into the map.
            map.put(curr, new Node(curr.val));
            // We move to next node and continue...until we reach the end
            curr = curr.next;
        }
        
        curr = head;
        // We traverse the original list again
        while (curr != null) {
            // If we are not in the last node...
            if (curr.next != null)
                // point the copy.next(1') of currNode(1) to
                // the copy of next node of currNode(1).
                map.get(curr).next = map.get(curr.next);
            
            // if currNode's random doesn't point to null 
            if (curr.random != null)
                // point the copy.random(1') of currNode(1) to
                // the copy(3') of random node(3) of currNode(1).
                map.get(curr).random = map.get(curr.random);
                
            // Move to next node in original
            curr = curr.next;
        }
        
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        next = null;
        random = null;
    }
}