package sdesheet.LeetCode.Sept22;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

public class NaryTreeLevelOrderTraversal {
    // -------------------------Using BFS-----------------------------------
    public List<List<Integer>> levelOrderBfs(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Queue<Node> currLevel = new LinkedList<>();
        currLevel.offer(root);
        
        while (!currLevel.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            // current size of queue
            int len = currLevel.size();
            // Iterate over the queue only till the current size as 
            // during iteration new child nodes qill be added
            for (int i = 0; i < len; i++) {
                // Get the top from queue
                Node node = currLevel.poll();
                curr.add(node.val);
                // Add the children of current node to queue
                for (Node child: node.children)
                    // check if the child is not null
                    if (child != null) currLevel.offer(child);
            }
            
            res.add(curr);
        }
        
        return res;
    }

    // ----------------------------- Using DFS -----------------------------
    List<List<Integer>> order;
    public List<List<Integer>> levelOrderDfs(Node root) {
        order = new ArrayList<>();
        return dfs(root, 0);
    }
    
    private List<List<Integer>> dfs(Node node, int level){
        if (node == null){
            return order;
        }
        List<Integer> list = order.size() > level ? order.get(level) : new ArrayList<>();
        list.add(node.val);
        if (order.size() <= level){
            order.add(list);
        }
        for (Node n : node.children){
            dfs(n, level + 1);
        }
        return order;
    }
}
