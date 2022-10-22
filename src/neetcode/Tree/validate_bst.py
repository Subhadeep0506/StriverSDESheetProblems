from typing import Optional
from sdesheet.Day17.tree_node import TreeNode

class ValidateBST:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, float("-inf"), float("inf"))

    def helper(self, root, left, right):
        if not root:
            return True
        
        if not (root.val > left and root.val < right):
            return False

        return self.helper(root.left, left, root.val) and self.helper(root.right, root.val, right)