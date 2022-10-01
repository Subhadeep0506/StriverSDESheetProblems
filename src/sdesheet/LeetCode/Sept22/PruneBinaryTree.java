package sdesheet.LeetCode.Sept22;

public class PruneBinaryTree {
	public TreeNode pruneTree(TreeNode root) {
        // If the current node is null return null
        if (root == null)
            return null;
        
        // Prune the left and right sub tree recursively
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        // If the current node is a leaf node and has a value 0
        // prune it
        if (root.left == null && root.right == null && root.val == 0)
            root = null;
        
        // return the current node
        return root;
    }
}