class BalancedTree:
	is_balanced = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.calc_height(root)
        return self.is_balanced
        
    def calc_height(self, root):
        if not root:
            return 0
        
        # Calculate height of left and right subtree
        left_height = self.calc_height(root.left)
        right_height = self.calc_height(root.right)
        
        # If the height difference is more than 1, return false
        if abs(right_height - left_height) > 1:
            self.is_balanced = False
        
        return 1 + max(left_height, right_height)