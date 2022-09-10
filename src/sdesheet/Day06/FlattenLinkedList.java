/*
 * Given a Linked List of size N, where every node represents a sub-linked-list and
 * contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked-list is in sorted order.
 * Flatten the Link List such that all the nodes appear in a single level while
 * maintaining the sorted order.
 *  
 * Note: The flattened list will be printed using the bottom pointer instead of next
 * pointer. For more clearity have a look at the printList() function in the driver code.
 * 
 * Input:
 * 5 -> 10 -> 19 -> 28
 * |     |     |     | 
 * 7     20    22   35
 * |           |     | 
 * 8          50    40
 * |                 | 
 * 30               45
 * Output:  5-> 7-> 8- > 10 -> 19-> 20->22-> 28-> 30-> 35-> 40-> 45-> 50.
 * Explanation:
 * The resultant linked lists has every 
 * node in a single level.
 * (Note: | represents the bottom pointer.)
 */

package sdesheet.Day06;

public class FlattenLinkedList {
    Node merge(Node a, Node b){
        if(a == null)
            return a;
        if(b == null)
            return b;
        
        Node c1 = a;
        Node c2 = b;
        Node p1 = null;
        Node newHead = null;
        
        while(c1 != null && c2 != null){
            if(c1.data <= c2.data){
                if(newHead == null)
                    newHead = c1;
                p1 = c1;
                c1 = c1.bottom;
            }
            else{
                //insert c2 between p1 and c1
                Node n2 = c2.bottom;
                if(newHead == null)
                    newHead = c2;
                if(p1 != null)
                    p1.bottom = c2;
                p1 = c2;
                c2.bottom = c1;
                c2 = n2;
            }
        }
        
        if(c2 != null)
            p1.bottom = c2;
        return newHead;
    }
    Node flatten(Node root) {
        // if the list is empty or if the list has only the bottom elements then return root itself
        if(root == null || root.next == null)
            return root;
        
        Node head = root.next;
        while (head != null) {
            Node nextHead = head.next;
            root = merge(head, root);
            head = nextHead;
        }
        root.next = null;
        return root;
    }
}
