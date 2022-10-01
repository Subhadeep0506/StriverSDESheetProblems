class MaxSumPath:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float("-inf")
        self.helper(root)
        return self.max_sum
    
    def helper(self, root):
        if not root:
            return 0
        
        left = max(0, self.helper(root.left))
        right = max(0, self.helper(root.right))
        self.max_sum = max(self.max_sum, left + right + root.val)
        return max(left, right) + root.val