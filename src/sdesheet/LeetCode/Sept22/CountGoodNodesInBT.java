/*
 * Given a binary tree root, a node X in the tree is named good if in the path from root 
 * to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * 
 *      3*
 *     / \
 *    1   4*
 *   /   / \
 * 3*   1   5*
 * Nodes with * are good nodes
 */

package sdesheet.LeetCode.Sept22;

public class CountGoodNodesInBT {
    public int goodNodes(TreeNode root) {
        // We will do a DFS traversal on the entire tree
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs (TreeNode root, int prevMax) {
        // If we are at a leaf node we return 1 only if the value of 
        // that node is greater than previous max value, else return 0
        if (root.left == null && root.right == null)
            return root.val >= prevMax ? 1 : 0;
        // Initialize the count variable with 0
        int count = 0;
        // If the value of current node is greater than or equal to
        // the previous maxValue, we count it
        count += (root.val >= prevMax) ? 1 : 0;
        
        // We do dfs traversal on left and right nodes as well, 
        // only if they exist
        if (root.left != null)
            count += dfs(root.left, Math.max(root.val, prevMax));
        if (root.right != null)
            count += dfs(root.right, Math.max(root.val, prevMax));
        
        // Then return the count
        return count;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
