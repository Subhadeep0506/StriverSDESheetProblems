package sdesheet.Day17;

import java.util.*;

class Pair {
    int index;
    Node node;
    Pair(int index, Node node){
        this.index = index;
        this.node = node;
    }
}

public class TopViewTree {
	public static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> res = new ArrayList<>();
        // Base case
        if (root == null)
            return res;
            
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            int index = curr.index;
            int data = curr.node.data;
            if (!map.containsKey(index))
                map.put(index, data);
                
            if (curr.node.left != null)
                queue.add(new Pair(index - 1, curr.node.left));
            if (curr.node.right != null)
                queue.add(new Pair(index + 1, curr.node.right));
        }
        
        for (Map.Entry<Integer, Integer> set: map.entrySet())
            res.add(set.getValue());
        
        return res;
    }
} 