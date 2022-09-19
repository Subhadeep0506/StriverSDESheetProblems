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