from tree_node import TreeNode

class PathToNode:
	def solve(self, root: TreeNode, V: int):
        res = []
        self.helper(root, V, res)
        return res
        
    def helper(self, root: TreeNode, V: int, res: List[int]) -> bool:
        if not root:
            return False
        
        res.append(root.val)
        
        if root.val == V:
            return True
        
        if self.helper(root.left, V, res) or self.helper(root.right, V, res):
            return True
            
        res.pop()
        return False