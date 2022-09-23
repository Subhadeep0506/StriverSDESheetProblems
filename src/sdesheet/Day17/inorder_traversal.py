from tree_node import TreeNode
from typing import *

class InorderTraversal:
	def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
	    res = []
        self.inorder_dfs(root, res)
        return res
    
    def inorder_dfs(self, root, res):
        if not root:
            return
        
        if root.left:
            self.inorder_dfs(root.left, res)
        res.append(root.val)
        if root.right:
            self.inorder_dfs(root.right, res)

    # -------------- Morris Inorder ------------------------------------
    def inorderTraversalMorris(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root
        
        while (curr):
            # if current node has no left node
            if not curr.left:
                # add the node val to res, and traverse right
                res.append(curr.val)
                curr = curr.right
            else:
                prev = curr.left
                # traverse to rightmost node of root
                while prev.right and prev.right != curr:
                    prev = prev.right
                # when we reach rightmost node, point its right to the root
                if not prev.right:
                    prev.right = curr
                    curr = curr.left
                # if we already have the node pointed
                else:
                    # add the value of current root to result and move right
                    prev.right = None
                    res.append(curr.val)
                    curr = curr.right
                
        return res