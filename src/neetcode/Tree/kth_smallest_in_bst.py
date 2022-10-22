from typing import Optional
from sdesheet.Day17.tree_node import TreeNode

class KThSmallestInBST:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:  # type: ignore
        stack = []
        curr = root

        while stack or curr:
            while curr:
                stack.append(curr)
                curr = curr.left
            
            curr = stack.pop()
            k -= 1
            if k == 0:
                return curr.val
            
            curr = curr.right