package sdesheet.LeetCode.Aug22;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) { //base condition
            return root;
        }
        
        //we use a while loop to traverse in the BST
        while(root != null) {
            
            //if the value of current node is greater than both the value then we go on the left side
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
                
            //if the value of current node is lesser than both the value then we go on the right side
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
                
            //if both the condition fails then it means that one node is on the left and the other node is on the right side, so in this case LCA will be the current node itself. So we break the loop and return the current node as LCA
            } else {
                break;
            }
        }
        return root;
    }
}
