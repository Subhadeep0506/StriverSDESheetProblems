package sdesheet.Day17;

import java.util.*;

class Node {
	int data;
	int hd;
	Node left;
	Node right;
	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class BottomViewTree {
	public ArrayList <Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        // Map to store horizontal distance as key and the value associated with it
        Map<Integer, Integer> map = new TreeMap<>();
        // Queue to push the nodes levelwise
        Queue<Node> queue = new LinkedList<>();
        // 1st, set horizontal distance of root to 0, and add the node to queue
        root.hd = 0;
        queue.add(root);
        // Loop until queue is empty
        while (!queue.isEmpty()) {
        	// Get the 1st node every time ,and remove it
            Node curr = queue.remove();
            // Put the cuur node's horizontal distance as key and its data as value
            map.put(curr.hd, curr.data);
            // If curr node has left child...
            if (curr.left != null) {
            	// ...set its horizontal distance to curr horizontal distance - 1 
                curr.left.hd = curr.hd - 1;
                // Add it to queue
                queue.add(curr.left);
            }
            // Similarly with the left node
            if (curr.right != null) {
                curr.right.hd = curr.hd + 1;
                queue.add(curr.right);
            }
        }
        
        // Now store all the values from map to an array[the map entries will all 
        // be in sorted order]
        for (Map.Entry<Integer, Integer> set: map.entrySet())
            res.add(set.getValue());
        
        return res;
    }
}